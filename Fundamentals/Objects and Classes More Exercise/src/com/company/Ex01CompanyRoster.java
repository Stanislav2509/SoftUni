package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01CompanyRoster {
    static class Employee{
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return  this.name + " " + String.format("%.2f", this.salary) + " " + this.email + " " + this.age ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countEmployees=Integer.parseInt(scanner.nextLine());
        List<Employee> employees=new ArrayList<>();

        for(int i=0;i<countEmployees;i++){
            String [] data=scanner.nextLine().split(" ");
            Employee employee=new Employee();
            employee.setName(data[0]);
            employee.setSalary(Double.parseDouble(data[1]));
            employee.setPosition(data[2]);
            employee.setDepartment(data[3]);

            if (data.length==5){
                if(data[4].contains("@")){
                    employee.setEmail(data[4]);
                }else {
                    employee.setAge(Integer.parseInt(data[4]));
                }
            }

            if (data.length==6){
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }

            employees.add(employee);
        }

        List<Employee> employeesInRichDepartment=new ArrayList<>();
        String biggestRichDepartment="";
        double avgSalary=0;
        for (int i=0;i<employees.size()-1;i++){
            double sumSalaryOnDepartments=employees.get(i).getSalary();
            double currentAvgSalary;
            int countRepeatDepartment=1;
            employeesInRichDepartment.add(employees.get(i));

            for(int k=i+1;k<employees.size();k++){
                if(employees.get(i).getDepartment().equals(employees.get(k).getDepartment())){
                    countRepeatDepartment++;
                    sumSalaryOnDepartments+=employees.get(k).getSalary();
                    employeesInRichDepartment.add(employees.get(k));
                    employees.remove(k);
                    k--;
                }
            }
            currentAvgSalary=sumSalaryOnDepartments/countRepeatDepartment;
            if(currentAvgSalary>avgSalary){
                avgSalary=currentAvgSalary;
                biggestRichDepartment=employees.get(i).getDepartment();

                for (int j=0;j<employeesInRichDepartment.size()-countRepeatDepartment;j++){
                    employeesInRichDepartment.remove(j);
                    j--;
                }
            }else {
                int size=employeesInRichDepartment.size();
                for (int j=employeesInRichDepartment.size()-1;j>=size-countRepeatDepartment;j--){
                    employeesInRichDepartment.remove(j);

                }
            }
        }


        for(int i=0;i<employeesInRichDepartment.size();i++){
            for(int j=1;j<employeesInRichDepartment.size()-i;j++){
                Employee employee=new Employee();
                if(employeesInRichDepartment.get(j-1).getSalary()<employeesInRichDepartment.get(j).getSalary()){
                    employee=employeesInRichDepartment.get(j-1);
                    employeesInRichDepartment.set(j-1,employeesInRichDepartment.get(j));
                    employeesInRichDepartment.set(j,employee);
                }
            }

        }


        System.out.println("Highest Average Salary: "+biggestRichDepartment);
        for (Employee employee : employeesInRichDepartment) {
            if (employee.getEmail() == null) {
                employee.setEmail("n/a");
            }
            if (employee.getAge() == 0) {
                employee.setAge(-1);
            }
            System.out.println(employee);
        }
    }

    //4
    //Peter 120.00 Dev Development peter@abv.bg 28
    //Todor 333.33 Manager Marketing 33
    //Itan 840.20 ProjectLeader Development itan@itan.com
    //George 0.20 Freeloader Nowhere 18

//    6
//    Stan 496.37 Temp Coding stan@yahoo.com
//    Yana 610.13 Manager Sales
//    Todor 609.99 Manager Sales todor@abv.bg 44
//    Venecia 0.02 Director BeerDrinking beer@beer.br 23
//    Andrey 700.00 Director Coding
//    Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey

}
