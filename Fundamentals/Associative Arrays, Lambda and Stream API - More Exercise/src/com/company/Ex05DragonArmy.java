package com.company;

import java.util.*;

public class Ex05DragonArmy {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, List<String>>typeName=new LinkedHashMap<>();
        Map<String, List<Integer>>nameData=new LinkedHashMap<>();
        int countDragons=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<countDragons;i++){
            String []data = scanner.nextLine().split(" ");
            String type=data[0];
            String name=data[1];
            int damage=0;
            int health=0;
            int armor=0;
            if(data[2].equals("null")){
                damage=45;
            }else {
                damage=Integer.parseInt(data[2]);
            }
            if(data[3].equals("null")){
                health=250;
            }else {
                health=Integer.parseInt(data[3]);
            }
            if(data[4].equals("null")){
                armor=10;
            }else {
                armor=Integer.parseInt(data[4]);
            }

            typeName.putIfAbsent(type,new ArrayList<>());
            if(!typeName.get(type).contains(name)){
                typeName.get(type).add(name);
                nameData.putIfAbsent(name,new ArrayList<>());
                nameData.get(name).add(damage);
                nameData.get(name).add(health);
                nameData.get(name).add(armor);
            }else {
                nameData.get(name).set(0,damage);
                nameData.get(name).set(1,health);
                nameData.get(name).set(2,armor);
            }



        }
        for (Map.Entry<String, List<String>> entry : typeName.entrySet()) {
            String type= entry.getKey();
            List<String> names=entry.getValue();
            List<String> copyNames=new ArrayList<>(names);
            Collections.sort(names);
            double sumDamege=0;
            double avgDamege=0;
            double sumHealth=0;
            double avgHealth=0;
            double sumArmor=0;
            double avgArmor=0;
            for(int i=0;i<names.size();i++) {
                sumDamege += nameData.get(names.get(i)).get(0);
                avgDamege = sumDamege / names.size();
                sumHealth += nameData.get(names.get(i)).get(1);
                avgHealth = sumHealth / names.size();
                sumArmor += nameData.get(names.get(i)).get(2);
                avgArmor = sumArmor / names.size();
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",type,avgDamege,avgHealth,avgArmor);
            for(int i=0;i<names.size();i++) {
                String name= names.get(i);
                for(int k=0;k<copyNames.size();k++){
                    String currentName=copyNames.get(k);
                    if(name.equals(currentName)){
                        List<Integer> data=nameData.get(currentName);
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",currentName,data.get(0),
                                data.get(1),data.get(2));
                    }
                }
            }

        }
    }
}
