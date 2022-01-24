package com.example.ggulmusae_shinhan;

import com.google.gson.annotations.SerializedName;

public class DbResponse {
    @SerializedName("id")
    public String id;
    @SerializedName("stock")
    public String stock;
    @SerializedName("buy_price")
    public String buy_price;
    @SerializedName("buy_date")
    public String buy_date;
    @SerializedName("sell_price")
    public String sell_price;
    @SerializedName("sell_date")
    public String sell_date;
}
