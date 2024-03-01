package com.itheima.studentsystemspringbootitaem.pojo;

public class Course {
    private Integer id;
    private String courseName;
    private Integer people;
    private String teacher;
    private String address;
    private Integer learningStyle;
    private double credit;

    public Course() {
    }

    public Course(Integer id, String courseName, Integer people, String teacher, String address, Integer learningStyle, double credit) {
        this.id = id;
        this.courseName = courseName;
        this.people = people;
        this.teacher = teacher;
        this.address = address;
        this.learningStyle = learningStyle;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLearningStyle() {
        return learningStyle;
    }

    public void setLearningStyle(Integer learningStyle) {
        this.learningStyle = learningStyle;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", people=" + people +
                ", teacher='" + teacher + '\'' +
                ", address='" + address + '\'' +
                ", learningStyle=" + learningStyle +
                ", credit=" + credit +
                '}';
    }
}
