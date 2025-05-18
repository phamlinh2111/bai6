package com.example.bai6;

public class Student {
    private int id;
    private String name;
    private String mssv;
    private String avatar;
    private String phone;
    private String year;
    private String major;
    private String planfuture;

    public Student(int id, String name, String mssv, String avatar,
                   String phone, String year, String major, String planfuture) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.avatar = avatar;
        this.phone = phone;
        this.year = year;
        this.major = major;
        this.planfuture = planfuture;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getMssv() { return mssv; }
    public String getAvatar() { return avatar; }
    public String getPhone() { return phone; }
    public String getYear() { return year; }
    public String getMajor() { return major; }
    public String getPlanfuture() { return planfuture; }
}

