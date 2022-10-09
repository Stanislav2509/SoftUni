package com.company;

import java.util.*;

public class Ex04Snowwhite {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, List<String>> dwarfHatColor =new LinkedHashMap<>();
        Map<String, List<Integer>>dwarfPhysics =new LinkedHashMap<>();
        String input=scanner.nextLine();
        while (!input.equals("Once upon a time")){
            String name=input.split(" <:> ")[0];
            String hatColor=input.split(" <:> ")[1];
            int physics= Integer.parseInt(input.split(" <:> ")[2]);

            if(!dwarfHatColor.containsKey(name)){
                dwarfHatColor.put(name,new ArrayList<>());
                dwarfHatColor.get(name).add(hatColor);
                dwarfPhysics.put(name,new ArrayList<>());
                dwarfPhysics.get(name).add(physics);
            }else {
                List<String> hatColorsList= dwarfHatColor.get(name);
                List<Integer> physicsList=dwarfPhysics.get(name);
                if(!hatColorsList.contains(hatColor)){
                    dwarfHatColor.get(name).add(hatColor);
                    dwarfPhysics.get(name).add(physics);
                }else {
                    for(int i=0;i<hatColorsList.size();i++){
                        if(hatColorsList.get(i).equals(hatColor)&&physicsList.get(i)<physics){
                            physicsList.set(i,physics);
                        }
                    }
                }
            }

            input=scanner.nextLine();
        }
        List<Integer>allPhysics=new ArrayList<>();
        List<String>allDwarf=new ArrayList<>();
        List<String>allHatColor=new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : dwarfPhysics.entrySet()) {

            for (Integer value : entry.getValue()) {
                allPhysics.add(value);
                allDwarf.add(entry.getKey());

            }
            for(String color:dwarfHatColor.get(entry.getKey())){
                allHatColor.add(color);
            }
        }
        List<Integer>copyAllPhysics=new ArrayList<>();
        for (Integer s : allPhysics) {
            copyAllPhysics.add(s);
        }
        List<String>copyDwarf=new ArrayList<>();
        for(String s:allDwarf){
            copyDwarf.add(s);
        }
        List<String>copyHatColor=new ArrayList<>();
        for(String s:allHatColor){
            copyHatColor.add(s);
        }
        Collections.sort(allPhysics);
        Collections.reverse(allPhysics);
        for(int i=0;i< allPhysics.size();i++){
            int physic=allPhysics.get(i);
            loop:for(int k=0;k< copyAllPhysics.size();k++) {
                int currentPhysics=copyAllPhysics.get(k);
                if(physic== currentPhysics){
                    String currentHatColor=copyHatColor.get(k);
                    allHatColor.add(i,currentHatColor);
                    String currentDwarf = copyDwarf.get(k);
                    allDwarf.add(i, currentDwarf);
                    copyHatColor.remove(k);
                    copyDwarf.remove(k);
                    copyAllPhysics.remove(k);
                    allHatColor.remove(allHatColor.size()-1);
                    allDwarf.remove(allDwarf.size() - 1);
                    break loop;

                }
            }
        }

        List<String>namesWithEqualsPhysic=new ArrayList<>();
        List<String>hatColorWithEqualsPhysic=new ArrayList<>();
        List<Integer>indexOnNamesWithEqualsPhysic=new ArrayList<>();

        copyAllPhysics=new ArrayList<>(allPhysics);
        copyDwarf=new ArrayList<>(allDwarf);
        copyHatColor=new ArrayList<>(allHatColor);
        for(int i=0;i< allPhysics.size();i++){
            int index=i;
            int phys=allPhysics.get(i);
          for(int k=0;k< copyAllPhysics.size();k++){
                int currentPhys=copyAllPhysics.get(k);
                if(phys==currentPhys){
                    namesWithEqualsPhysic.add(copyDwarf.get(k));
                    indexOnNamesWithEqualsPhysic.add(index);
                    hatColorWithEqualsPhysic.add(copyHatColor.get(k));
                    copyAllPhysics.remove(k);
                    copyHatColor.remove(k);
                    copyDwarf.remove(k);
                    k--;
                }
                index++;
            }

            if(namesWithEqualsPhysic.size()==1){
                namesWithEqualsPhysic.clear();
                indexOnNamesWithEqualsPhysic.clear();
                hatColorWithEqualsPhysic.clear();
            }
        }
        List<String>color=new ArrayList<>(hatColorWithEqualsPhysic);
        if(namesWithEqualsPhysic.size()>1){
            Collections.sort(hatColorWithEqualsPhysic);
            String name="";
            for(int i=0;i<indexOnNamesWithEqualsPhysic.size();i++){
                loop:for(int k=0;k<color.size();k++){
                    String hatColor=hatColorWithEqualsPhysic.get(i);
                    String currentColor=color.get(k);
                    if(hatColor.equals(currentColor)){
                         name=namesWithEqualsPhysic.get(k);
                         namesWithEqualsPhysic.remove(k);
                         color.remove(k);
                         break loop;
                    }
                }
                int index=indexOnNamesWithEqualsPhysic.get(i);
                String hatColor=hatColorWithEqualsPhysic.get(i);
                allDwarf.set(index,name);
                allHatColor.set(index,hatColor);
            }
        }
        for(int i=0;i< allDwarf.size();i++){
            System.out.printf("(%s) %s <-> %d%n",allHatColor.get(i),allDwarf.get(i),allPhysics.get(i));
        }
    }

}
