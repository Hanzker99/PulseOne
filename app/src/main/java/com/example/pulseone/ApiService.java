package com.example.pulseone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers("Content-Type: application/xml")
    @POST("/api/loginPacient")
    <LoginResponse>
    Call<LoginResponse> login(@Body String request);
}