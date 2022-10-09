package com.company;

import java.util.*;

public class Ex05AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradesByName=new TreeMap<>();
        while (n-->0){
            String input= scanner.nextLine();
            String name= input.split(" ")[0];
            double grade= Double.parseDouble(input.split(" ")[1]);

            gradesByName.putIfAbsent(name,new ArrayList<>());
            List<Double>grades= gradesByName.get(name);
            grades.add(grade);
            gradesByName.put(name,grades);
        }
        for(var entry:gradesByName.entrySet()){
            String name= entry.getKey();
            List<Double>grades=entry.getValue();
            double sum=0;
            System.out.print(name +" -> ");
            for(double grade: grades){
                sum+=grade;
                System.out.printf("%.2f ",grade);
            }
            System.out.printf("(avg: %.2f)%n",sum/ grades.size());
        }
    }
}
