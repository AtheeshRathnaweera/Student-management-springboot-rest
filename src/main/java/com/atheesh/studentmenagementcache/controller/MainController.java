package com.atheesh.studentmenagementcache.controller;

import com.atheesh.studentmenagementcache.apis.SmsAPIs;
import com.atheesh.studentmenagementcache.apis.StudentAPIs;
import com.atheesh.studentmenagementcache.beans.SMS;
import com.atheesh.studentmenagementcache.beans.Student;
import com.atheesh.studentmenagementcache.utils.RetrofitClient;
import com.atheesh.studentmenagementcache.utils.Values;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studentmanagement")
public class MainController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/")
    // Define the Hello World controller.
    public String hello() {
        System.out.println("Student management received hello");

        ValueOperations<String, String> ops = this.template.opsForValue();

        // Add a Hello World string to your cache.
        String key = "greeting";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello World!");
        }

        // Return the string from your cache.
        return ops.get(key);
    }

    @RequestMapping("/getAllStudents")
    private List<Student> getAllStudents() {
        StudentAPIs STUDENT_API = new RetrofitClient(Values.MAIN_URL).getRetrofit().create(StudentAPIs.class);

        List<Student> recStudentData = new ArrayList<>();

        try {
            Call<List<Student>> getAllStudents = STUDENT_API.getAllStudents();
            Response<List<Student>> res = getAllStudents.execute();
            recStudentData = res.body();
        } catch (IOException ex) {
            System.out.println("Exception in getAllStudents : " + ex);
        }

        return recStudentData;
    }

    @PostMapping("/sendSMS")
    private String sendSMS(@RequestBody SMS sms) {
        SmsAPIs SMS_API = new RetrofitClient(Values.SMS_FUNC_URL).getRetrofit().create(SmsAPIs.class);

        try {
            Call<String> sendSMSCall = SMS_API.sendNewSMS(sms);
            Response<String> res = sendSMSCall.execute();
            return res.body();
        } catch (IOException ex) {
            System.out.println("Exception in sendSMS : " + ex);
            return "send failed";
        }
    }
}