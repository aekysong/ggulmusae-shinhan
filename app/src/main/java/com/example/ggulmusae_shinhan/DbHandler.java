package com.example.ggulmusae_shinhan;

import static com.example.ggulmusae_shinhan.MainActivity.threadHandler;

import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DbHandler implements ApiRunnable {
    private static final String TAG = "ApiService";

    public static String BaseUrl = "https://script.google.com/macros/s/AKfycbxnegWc9-vAUwVinyRfggkb2oPSjv2HFfu9ZkT-67kwOgGycAQqY5bCwitER5mKowDEmQ";
    public static String sheetName;
    public static String requestType;
    Map<String, Object> result = new HashMap<>();


    @Override
    public void setDbParams(String sheetName, String requestType) {
        this.sheetName = sheetName;
        this.requestType = requestType;
    }

    @Override
    public void run() {
        Log.d(TAG, "sheetName: " + sheetName + " / requestType: " + requestType);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DbService dbService = retrofit.create(DbService.class);
        Call<DbResponse> call = dbService.getUserData(sheetName, requestType);
        call.enqueue(new Callback<DbResponse>() {
            @Override
            public void onResponse(@NonNull Call<DbResponse> call, @NonNull Response<DbResponse> response) {
                if (response.code() == 200) {
                    DbResponse dbResponse = response.body();
                    Log.d(TAG, "onResponse: " + dbResponse);
                    assert dbResponse != null;

//                    String stringBuilder = "Location: "
//                            + weatherResponse.name + " in " + weatherResponse.sys.country +
//                            "\n" +
//                            "Temperature: "
//                            + weatherResponse.main.temp +
//                            "\n" +
//                            "Humidity: " +
//                            weatherResponse.main.humidity;
//
//                    result.put("description", weatherResponse.weather.get(0).description);
//                    result.put("stringBuilder", stringBuilder);
//                    result.put("icon", weatherResponse.weather.get(0).icon);
//                    result.put("temperature", weatherResponse.main.temp);
//
                    Message msg = new Message();
                    msg.obj = result;
                    threadHandler.sendMessage(msg);
                }
    }

            @Override
            public void onFailure(Call<DbResponse> call, Throwable t) {

            }
        }

