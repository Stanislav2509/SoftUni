package com.company;

import java.util.*;

public class Ex07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsAllGrade=new LinkedHashMap<>();
        Map<String, Double> studentsAvgGrade=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String name= scanner.nextLine();
            double grade=Double.parseDouble(scanner.nextLine());
            if(studentsAllGrade.containsKey(name)){
                studentsAllGrade.get(name).add(grade);
            }else {
                studentsAllGrade.put(name,new ArrayList<>());
                studentsAllGrade.get(name).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsAllGrade.entrySet()) {
            double sumGrade=0;
            for (Double grade : entry.getValue()) {
                sumGrade+=grade;
            }
            studentsAvgGrade.put(entry.getKey(),sumGrade/(double) entry.getValue().size());
        }
        studentsAvgGrade.entrySet().stream().filter(entry->entry.getValue()>=4.50)
                .forEach(entry->System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));

    }
}
