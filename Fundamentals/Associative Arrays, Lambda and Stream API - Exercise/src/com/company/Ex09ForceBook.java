package com.company;

import java.util.*;

public class Ex09ForceBook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, List<String>>sideUsers=new LinkedHashMap<>();
        while (!input.equals("Lumpawaroo")){
            if(input.contains("->")){
                String user=input.split(" -> ")[0];
                String side=input.split(" -> ")[1];
                sideUsers.entrySet().forEach(entry->entry.getValue().remove(user));

                if(sideUsers.containsKey(side)){
                    sideUsers.get(side).add(user);

                } else if(!sideUsers.containsKey(side)&&!sideUsers.containsValue(user)){
                    sideUsers.put(side,new ArrayList<>());
                    sideUsers.get(side).add(user);
                }
               System.out.printf("%s joins the %s side!%n",user,side);
            }else {
                String side=input.split(" \\| ")[0];
                String user=input.split(" \\| ")[1];

                if(!sideUsers.containsKey(side)){
                    sideUsers.put(side,new ArrayList<>());
                }
                boolean isExist=false;
                for (List<String> value : sideUsers.values()) {
                    if(value.contains(user)){
                        isExist=true;
                    }
                }
                if(!isExist){
                    sideUsers.get(side).add(user);
                }

            }
            input= scanner.nextLine();
        }

       sideUsers.entrySet().stream().filter(entry->entry.getValue().size()>0)
               .forEach(entry->{
                   System.out.printf("Side: %s, Members: %d%n",entry.getKey(),entry.getValue().size());
                   entry.getValue().forEach(user-> System.out.println("! "+user));
               });
    }
}
