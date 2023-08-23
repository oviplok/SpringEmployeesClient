package com.example.springemployeesclient.model;




public class Employee {

    private int id;
    private String fio;
    private String location;
    private String branch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + fio + '\'' +
                ", location='" + location + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}