package ru.skypro.hw2.course4.hw2course4.pojo;

public class Employee {
    private  int id;
    private String name;
    private int salary;
    private static int count = 1;

    public Employee(String name, int salary) {
        this.id = count;
        this.name = name;
        this.salary = salary;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
