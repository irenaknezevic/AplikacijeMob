package com.example.mojaaplikacija;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class CourseResponse {
    ArrayList<Course> courses;

    @NonNull
    @Override
    public String toString() {
        return courses.toString();
    }
}