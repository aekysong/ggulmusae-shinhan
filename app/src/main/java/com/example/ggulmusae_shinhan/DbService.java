package com.example.ggulmusae_shinhan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DbService {
    @GET("/exec?")
    Call<DbResponse> getUserData(@Query("sheet_name") String sheetName, @Query("request_type") String requestType);
}
