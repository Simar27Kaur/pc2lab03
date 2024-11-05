package com.example.lab3;

public class Employee {

    private int id;
    private String name;
    private String Address;
    private int Salary;
    public Employee(int id, String name, String Address, int Salary) {
        this.id = id;
        this.name = name;
        this.Address = Address;
        this.Salary = Salary;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return Address;
    }
    public int getSalary() {
        return Salary;
    }
}
