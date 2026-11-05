package com.nitish.sms.model;

public class Student {
    private int student_id;
    private String name;
    private String email;
    private long phone;
    private String gender;
    private String course;
    private String branch;
    private String address;




    public Student() {
    }

    public Student(int student_id, String name, String email, long phone, String gender, String course, String branch, String address) {
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.course = course;
        this.branch = branch;
        this.address = address;
    }



    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public String getBranch() {
        return branch;
    }

    public String getAddress() {
        return address;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
