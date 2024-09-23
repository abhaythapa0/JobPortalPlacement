package com.example.jobportalplacement;

public class Job {
    private int id;
    private String title;
    private String description;
    private String company;
    private String salary;
    private String location;

    // Empty constructor
    public Job() {
    }

    // Constructor with parameters
    public Job(int id, String title, String description, String company, String salary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.company = company;
        this.salary = salary;
        this.location = location;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
