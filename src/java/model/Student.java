/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date DOB;
    private static int nextID=0;

    public Student() {
        nextID++;
        id = nextID;
        name = genName();
        gender = genGen();
        DOB=genDOB();
    }

    public Student(int id, String name, boolean gender, Date DOB) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    private String genName()
    {
        int size;
        size = randBetween(4, 6);
        char[] name = new char[size];
        for (int i = 0; i < name.length; i++) {
            name[i]=(char)randBetween(65, 122);
        }
        return String.copyValueOf(name).replaceAll("[^A-Za-z]", "a");
    }
    private boolean genGen()
    {
        Random r = new Random();
        return r.nextBoolean();
    }
    private Date genDOB()
    {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1990, 2010);
        int month = randBetween(1, 12);
        int date = randBetween(1, 28);
        gc.set(year, month, date);
        return gc.getTime();
    }
    public String format()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(DOB);
    }
    public String getGender()
    {
        if(gender) return "Female";
        else return "Male";
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", DOB=" + format() + '}';
    }
    public static Student[] studentGen(int number)
    {
        Student s[] = new Student[number];
        for (int i = 0; i < s.length; i++) {
            s[i]=new Student();
        }
        return s;
    }
    public static void main(String[] args) {
        Student[] s = studentGen(5);
        for (Student student : s) {
            System.out.println(student);
        }
    }
}
