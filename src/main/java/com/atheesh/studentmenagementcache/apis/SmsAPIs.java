package com.atheesh.studentmenagementcache.apis;

import com.atheesh.studentmenagementcache.beans.SMS;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SmsAPIs {

    @POST("SendSMS")
    Call<String> sendNewSMS(@Body SMS sms);
}
