package com.example.mojaaplikacija;

import java.util.ArrayList;
import java.util.List;

public class MyDataStorage {

    private List<Student> students;

    private MyDataStorage() {
        students = new ArrayList<>();
    }

    static private MyDataStorage instance;

    static MyDataStorage getInstance() {
        if(instance==null) {
            instance = new MyDataStorage();
        }
        return instance;
    }

    List<Student> getStudents() {

        return students;
    }

    void addStudent(Student newStudent) {
        students.add(newStudent);
    }
}

class Student {
    public String sIme;
    public String sPrezime;
    public String sPredmet;

    public Student(String ime, String prezime, String predmet) {
        this.sIme = ime;
        this.sPrezime = prezime;
        this.sPredmet = predmet;
    }
}
