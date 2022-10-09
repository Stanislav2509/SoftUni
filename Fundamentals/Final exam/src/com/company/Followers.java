package com.company;

import java.util.*;

public class Followers {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, List<String>> followers=new LinkedHashMap<>();
        while (!input.equals("Log out")){
            String command=input.split(": ")[0];
            String username=input.split(": ")[1];
            switch (command){
                case "New follower":
                    newFollowerFunction(username,followers);
                    break;
                case "Like":
                    int count=Integer.parseInt(input.split(" ")[2]);
                    likeFunction(count,username,followers);
                    break;
                case "Comment":
                    commentFunction(username,followers);
                    break;
                case "Blocked":
                    blockedFunction(username,followers);
                    break;
            }
            input= scanner.nextLine();
        }
        print(followers);
    }

    private static void print(Map<String, List<String>> followers) {
        int countFollowers= followers.size();
        System.out.printf("%d followers%n",countFollowers);
        for(Map.Entry<String,List<String>>entry: followers.entrySet()){
            String username= entry.getKey();
            int sumLikesComments=0;
            for(int i=0;i<entry.getValue().size();i++){
                sumLikesComments+=Integer.parseInt(entry.getValue().get(i));
            }
            System.out.printf("%s: %d%n",username,sumLikesComments);
        }
    }

    private static void blockedFunction(String username, Map<String, List<String>> followers) {
        if(followers.containsKey(username)){
            followers.remove(username);
        }else {
            System.out.println(username+" doesn't exist.");
        }
    }

    private static void commentFunction(String username, Map<String, List<String>> followers) {
        if (followers.containsKey(username)) {
            int currentComments= Integer.parseInt(followers.get(username).get(1));
            followers.get(username).set(1,String.valueOf(currentComments+1));
        }else {
            followers.put(username,new ArrayList<>());
            followers.get(username).add("0");
            followers.get(username).add("1");
        }
    }

    private static void likeFunction(int count, String username, Map<String, List<String>> followers) {
        if (followers.containsKey(username)) {
            int currentLikes= Integer.parseInt(followers.get(username).get(0));
            followers.get(username).set(0, String.valueOf(currentLikes+count));
        }else {
            followers.put(username,new ArrayList<>());
            followers.get(username).add(String.valueOf(count));
            followers.get(username).add("0");
        }
    }

    private static void newFollowerFunction(String username, Map<String, List<String>> followers) {
        if(!followers.containsKey(username)){
            followers.putIfAbsent(username,new ArrayList<>());
            followers.get(username).add("0");
            followers.get(username).add("0");
        }
    }
}
