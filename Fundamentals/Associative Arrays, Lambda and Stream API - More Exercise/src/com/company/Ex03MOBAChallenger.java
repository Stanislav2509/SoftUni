package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, List<String>> playerPositions =new LinkedHashMap<>();
        Map<String,List<Integer>> playerSkills=new LinkedHashMap<>();
        Map<String, Integer> playerTotalPoints = new LinkedHashMap<>();

        String input= scanner.nextLine();

        while (!input.equals("Season end")){
            if(input.contains("->")){
                String name=input.split(" -> ")[0];
                String position=input.split(" -> ")[1];
                int skill= Integer.parseInt(input.split(" -> ")[2]);
                if(!playerPositions.containsKey(name)){
                    playerPositions.put(name,new ArrayList<>());
                    playerPositions.get(name).add(position);
                    playerSkills.put(name,new ArrayList<>());
                    playerSkills.get(name).add(skill);
                }else{
                    List<Integer> currentSkill=playerSkills.get(name);
                    List<String> currentPosition= playerPositions.get(name);
                    if(currentPosition.contains(position)){
                        for(int i=0;i<currentPosition.size();i++){
                            if(currentPosition.get(i).equals(position)){
                                if(currentSkill.get(i)<skill){
                                    currentSkill.set(i,skill);
                                }
                            }
                        }
                    }else {
                        playerSkills.get(name).add(skill);
                        playerPositions.get(name).add(position);
                    }
                }
            }else {
                String firstPlayer=input.split(" vs ")[0];
                String secondPlayer=input.split(" vs ")[1];
                if(playerPositions.containsKey(firstPlayer)&& playerPositions.containsKey(secondPlayer)){
                    battle(playerPositions,playerSkills,firstPlayer,secondPlayer);
                }
            }
            input= scanner.nextLine();
        }

        sortPositionsByPoints(playerPositions,playerSkills);
        insertPlayerTotalPoints(playerTotalPoints,playerSkills);

        List<String>sortedPlayer=playerTotalPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for(int i=0;i<sortedPlayer.size();i++){
            String player = sortedPlayer.get(i);
            System.out.println(player+": "+playerTotalPoints.get(player)+" skill");
            List<String> positions = playerPositions.get(player);
            List<Integer>skills=playerSkills.get(player);

            for(int k=0;k<positions.size();k++){
                System.out.printf("- %s <::> %d%n",positions.get(k),skills.get(k));
            }
        }
    }

    public static void battle(Map<String, List<String>> playerPositions, Map<String, List<Integer>> playerSkills,
                              String firstPlayer,String secondPlayer){
        List<String>firstPlayerPosition=playerPositions.get(firstPlayer);
        List<Integer>firstPlayerSkills=playerSkills.get(firstPlayer);
        List<String>secondPlayerPosition=playerPositions.get(secondPlayer);
        List<Integer>secondPlayerSkills=playerSkills.get(secondPlayer);
        int firstPlayerTotalPoints=0;
        int secondPlayerTotalPoints=0;
        for(int i=0;i<firstPlayerPosition.size();i++){
            for(int k=0;k<secondPlayerPosition.size();k++){
                if(firstPlayerPosition.get(i).equals(secondPlayerPosition.get(k))){
                    firstPlayerTotalPoints+=firstPlayerSkills.get(i);
                    secondPlayerTotalPoints+=secondPlayerSkills.get(k);
                }
            }
        }

        if(firstPlayerTotalPoints>secondPlayerTotalPoints){
            playerPositions.remove(secondPlayer);
            playerSkills.remove(secondPlayer);
        }else if(firstPlayerTotalPoints<secondPlayerTotalPoints){
            playerPositions.remove(firstPlayer);
            playerSkills.remove(firstPlayer);
        }
    }

    public static void insertPlayerTotalPoints(Map<String,Integer>  playerTotalPoints,Map<String, List<Integer>> playerSkills){
        for (Map.Entry<String, List<Integer>> entry : playerSkills.entrySet()) {
            String name= entry.getKey();
            List<Integer> skills = entry.getValue();
            int totalPoints=0;

            for (Integer skill : skills) {
                totalPoints+=skill;
            }
            playerTotalPoints.put(name,totalPoints);
        }
    }

    public static void sortPositionsByPoints(Map<String, List<String>> playerPositions, Map<String, List<Integer>> playerSkills) {
        for (Map.Entry<String, List<String>> entry : playerPositions.entrySet()) {
            String player = entry.getKey();
            List<String> positions = entry.getValue();
            List<Integer> skills = playerSkills.get(player);
            List<Integer> copySkills = new ArrayList<>();
            List<String> copyPositions = new ArrayList<>();
            for (int point : skills) {
                copySkills.add(point);
            }
            for (String user : positions) {
                copyPositions.add(user);
            }
            Collections.sort(skills);
            Collections.reverse(skills);
            for (int i = 0; i < skills.size(); i++) {
                loop:  for (int k = 0; k < copySkills.size(); k++) {
                    if (skills.get(i).equals(copySkills.get(k))) {
                        String currentUsers = copyPositions.get(k);
                        positions.add(i, currentUsers);
                        copyPositions.remove(k);
                        copySkills.remove(k);
                        positions.remove(positions.size() - 1);
                        break loop;
                    }
                }
            }
        }
    }
}
