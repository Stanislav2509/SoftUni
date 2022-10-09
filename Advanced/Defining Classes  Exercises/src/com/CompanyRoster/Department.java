package com.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees=new ArrayList<>();
    }

    public double calcAvgSalary(){
        return employees.stream().mapToDouble(employee ->employee.getSalary()).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
