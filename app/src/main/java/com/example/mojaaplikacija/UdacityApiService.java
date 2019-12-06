package com.example.mojaaplikacija;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UdacityApiService {
    @GET("/v1/courses")
    Call<CourseResponse> getCourses();
}


