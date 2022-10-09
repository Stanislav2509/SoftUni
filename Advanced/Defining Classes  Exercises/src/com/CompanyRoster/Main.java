package com.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countEmployees=Integer.parseInt(scanner.nextLine());
        List<Department>departments=new ArrayList<>();

        while (countEmployees-->0){
            String[] data=scanner.nextLine().split(" ");
            String name=data[0];
            double salary=Double.parseDouble(data[1]);
            String position=data[2];
            String departmentName=data[3];
            Employee employee=null;
            Department department=new Department(departmentName);
            switch (data.length){
                case 4:
                    employee=new Employee(name,salary,position,department);
                    break;
                case 5:
                    if(data[4].contains("@")){
                        String email=data[4];
                        employee =new Employee(name,salary,position,department,email);
                    }else {
                        int age=Integer.parseInt(data[4]);
                        employee =new Employee(name,salary,position,department,age);

                    }
                    break;
                case 6:
                    String email=data[4];
                    int age=Integer.parseInt(data[5]);
                    employee =new Employee(name,salary,position,department,email,age);
                    break;
            }

            boolean isExistDepartment=departments.stream()
                    .anyMatch(d->d.getName().equals(departmentName));

            if(!isExistDepartment){
                Department department1 =new Department(departmentName);
                departments.add(department1);
            }

            Department currDepartment=departments.stream().filter(dep->dep.getName().equals(departmentName))
                    .findFirst().get();
            currDepartment.getEmployees().add(employee);
        }
        Department highestPaidDepartment=departments.stream()
                .max((f,s)->Double.compare(f.calcAvgSalary(), s.calcAvgSalary())).get();

        System.out.println("Highest Average Salary: "+highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees().stream()
                .sorted((f,s)->Double.compare(s.getSalary(),f.getSalary()))
                .forEach(e-> System.out.println(e));
    }
}
