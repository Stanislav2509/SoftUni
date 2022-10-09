package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02Judge {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, List<String>> contestUsers = new LinkedHashMap<>();
        Map<String, List<Integer>> contestPoints = new LinkedHashMap<>();
        Map<String, Integer> userTotalPoints = new LinkedHashMap<>();

        while (!input.equals("no more time")){
            String username=input.split(" -> ")[0];
            String contest=input.split(" -> ")[1];
            int points= Integer.parseInt(input.split(" -> ")[2]);
            if(!contestUsers.containsKey(contest)){
                contestUsers.put(contest,new ArrayList<>());
                contestUsers.get(contest).add(username);
                contestPoints.put(contest,new ArrayList<>());
                contestPoints.get(contest).add(points);
            }else {
                if(!contestUsers.get(contest).contains(username)){
                    contestUsers.get(contest).add(username);
                    contestPoints.get(contest).add(points);
                }else {
                    List<String> users = contestUsers.get(contest);
                    List<Integer> contestPointsList = contestPoints.get(contest);
                    for(int i=0;i<users.size();i++){
                        if(users.get(i).equals(username)){
                            if(contestPointsList.get(i)<points){
                                contestPointsList.set(i,points);
                            }
                        }
                    }
                }
            }
            input= scanner.nextLine();
        }

        sortContestByPoints(contestUsers,contestPoints);
        for (Map.Entry<String, List<Integer>> entry : contestPoints.entrySet()) {
            List<Integer> value = entry.getValue();
            List<String> users = contestUsers.get(entry.getKey());
            List<String> usersWithEqualsPoints=new ArrayList<>();
            List<Integer> indexes=new ArrayList<>();
            for(int i=0;i<value.size()-1;i++){
                int points=value.get(i);
                for(int k=0;k<value.size();k++){
                    int currentPoints=value.get(k);
                    if(points==currentPoints&&!usersWithEqualsPoints.contains(users.get(k))){
                        usersWithEqualsPoints.add(users.get(k));
                        indexes.add(k);
                    }
                }
                if(usersWithEqualsPoints.size()==1){
                    usersWithEqualsPoints.clear();
                    indexes.clear();
                }
            }
            if(usersWithEqualsPoints.size()>1){
                Collections.sort(usersWithEqualsPoints);
                for(int i=0;i<indexes.size();i++){
                    int index=indexes.get(i);
                    String user=usersWithEqualsPoints.get(i);
                    users.set(index,user);
                }
            }
            usersWithEqualsPoints.clear();
            indexes.clear();
        }


        for (Map.Entry<String, List<String>> entry : contestUsers.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue().size()+" participants");
            List<String> users = entry.getValue();
            List<Integer> points = contestPoints.get(entry.getKey());
            for(int i=0;i<users.size();i++){
                System.out.printf("%d. %s <::> %d%n",i+1,users.get(i),points.get(i));

                if(!userTotalPoints.containsKey(users.get(i))){
                    userTotalPoints.put(users.get(i),points.get(i));
                }else {
                    userTotalPoints.put(users.get(i),userTotalPoints.get(users.get(i))+ points.get(i));
                }
            }
        }

        System.out.println("Individual standings: ");

        List<String>users= userTotalPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<Integer>points= userTotalPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        List<String>names=new ArrayList<>();
        List<Integer>index=new ArrayList<>();
        for(int i=0; i<points.size();i++){
            int pts=points.get(i);
            for(int k=0;k<points.size();k++){
                int currentpts=points.get(k);
                if(pts==currentpts&&!names.contains(users.get(k))){
                    names.add(users.get(k));
                    index.add(k);
                }
            }
            if(names.size()==1){
                names.clear();
                index.clear();
            }

        }

        if(names.size()>1){
            Collections.sort(names);
            Collections.reverse(names);
            for(int i=0;i<index.size();i++){
                int index1=index.get(i);
                String user=names.get(i);
                users.set(index1,user);
            }
        }

        for(int i=0;i<users.size();i++){
            System.out.println(i+1+". "+users.get(i)+" -> "+ points.get(i));
        }

    }


    public static void sortContestByPoints(Map<String, List<String>> contestUsers, Map<String, List<Integer>> contestPoints) {
        for (Map.Entry<String, List<String>> entry : contestUsers.entrySet()) {
            String contest = entry.getKey();
            List<String> users = entry.getValue();
            List<Integer> points = contestPoints.get(contest);
            List<Integer> copyPoints = new ArrayList<>();
            List<String> copyUsers = new ArrayList<>();
            for (int point : points) {
                copyPoints.add(point);
            }
            for (String user : users) {
                copyUsers.add(user);
            }
            Collections.sort(points);
            Collections.reverse(points);
            for (int i = 0; i < points.size(); i++) {
                loop:  for (int k = 0; k < copyPoints.size(); k++) {
                int score=points.get(i);
                int currentScore=copyPoints.get(k);
                    if (score==currentScore) {
                        String currentUsers = copyUsers.get(k);
                        users.add(i, currentUsers);
                        copyUsers.remove(k);
                        copyPoints.remove(k);
                        users.remove(users.size() - 1);
                        break loop;
                    }
                }
            }
        }
    }
}
