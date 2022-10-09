package com.company;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Ex08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Double> gradesByStudents=new TreeMap<>();
        while (n-->0){
            String name= scanner.nextLine();
            List<Double> grades= Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
            double avg=0;
            for(double grade: grades){
                avg+=grade;
            }
            avg=avg/ grades.size();

            gradesByStudents.putIfAbsent(name,avg);
        }
        for(var entry:gradesByStudents.entrySet()){
            DecimalFormat df=new DecimalFormat("#.############################");
            System.out.printf("%s is graduated with %s%n",entry.getKey(),df.format(entry.getValue()));
        }
    }
}
