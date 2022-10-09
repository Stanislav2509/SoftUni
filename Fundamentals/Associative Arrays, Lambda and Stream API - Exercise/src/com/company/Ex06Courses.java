package com.company;

import java.util.*;

public class Ex06Courses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, List<String>> courses=new LinkedHashMap<>();
        while (!input.equals("end")){
            String courseName=input.split(" : ")[0];
            String studentName=input.split(" : ")[1];
            if(courses.containsKey(courseName)){
                courses.get(courseName).add(studentName);
            }else {
                courses.put(courseName,new ArrayList<>());
                courses.get(courseName).add(studentName);
            }

            input= scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue().size());
            for (String stName : entry.getValue()) {
                System.out.printf("-- %s%n",stName);
            }

        }

    }
}
