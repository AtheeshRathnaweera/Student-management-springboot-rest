package com.atheesh.studentmenagementcache.apis;

import com.atheesh.studentmenagementcache.beans.Student;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface StudentAPIs {

    @GET("student/all")
    Call<List<Student>> getAllStudents();

    @GET("student/{id}")
    Call<Student> getStudentById(@Path("id") int id);

    @POST("student")
    Call<Student> saveANewStudent(@Body Student student);
}
