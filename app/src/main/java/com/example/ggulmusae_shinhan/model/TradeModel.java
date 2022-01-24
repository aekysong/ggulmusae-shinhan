package com.example.ggulmusae_shinhan.model;

import java.util.ArrayList;

public class TradeModel {
    String date = "2021/01/24";
    String market = "KOSPI";
    String name = "신한지주";
    int price = 3250;
    int count = 7;
    int profit = -12500;

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public int getProfit() {
        return profit;
    }

    public String getDate() {
        return date;
    }

    public String getMarket() {
        return market;
    }

    public String getName() {
        return name;
    }


    // Dummy Data
    public static ArrayList<TradeModel> createTradeDummyData(int type){

        ArrayList<TradeModel> data = new ArrayList<>();
        for(int i=0;i<6;i++)
            data.add(new TradeModel());
        return data;

    }
}
