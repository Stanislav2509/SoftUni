package com.company;

import java.util.*;

public class Ex08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, List<String> >companyUsers=new LinkedHashMap<>();

        while (!input.equals("End")){
            String name=input.split(" -> ")[0];
            String id= input.split(" -> ")[1];
            if(!companyUsers.containsKey(name)){
                companyUsers.put(name,new ArrayList<>());
                companyUsers.get(name).add(id);
            }else if(!companyUsers.get(name).contains(id)&&companyUsers.containsKey(name)){
                companyUsers.get(name).add(id);
            }

            input= scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyUsers.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println("-- "+s);
            }
        }

    }
}
