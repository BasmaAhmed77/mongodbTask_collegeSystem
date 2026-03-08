package org.example;

public class Student {

    private String name;
    private int age;
    private String governate;
    private String phoneNo;
    private int level;

    public Student(String n, int age, String gov, String no, int l)
    {
        name= n;
        this.age= age;
        governate= gov;
        phoneNo= no;
        level= l;
    }

    public String getName()
    {
        return name;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }
    public String getGovernate()
    {
        return governate;
    }

    public int getAge()
    {
        return age;
    }
     public int getLevel()
    {
        return level;
    }

}
