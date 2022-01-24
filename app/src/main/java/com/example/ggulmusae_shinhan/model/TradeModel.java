package com.example.ggulmusae_shinhan.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TradeModel {
    String date = "2021/01/24";
    String market = "KOSPI";
    String name = "신한지주";
    int price = 3250;
    int count = 7;
    int profit = -12500;
    DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");

    TradeModel(){}

    TradeModel(String date, String market, String name, int price, int count, int profit){
        this.date = date;
        this.market = market;
        this.name = name;
        this.price = price;
        this.count = count;
        this.profit = profit;
    }

    public String getCount() {
        return "*"+count+"주";
    }

    public String getPrice() {
        return formatter.format(price)+"원";
    }

    public String getProfit() {
        return formatter.format(profit)+"원";
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
    // type : 1 - 사지말껄, 2 - 팔지말껄, 3 - 잘했어
    public static ArrayList<TradeModel> createTradeDummyData(int type){
        ArrayList<TradeModel> data = new ArrayList<>();
        switch (type){
            case 1:
                for(int i=0;i<6;i++)
                    data.add(new TradeModel());
                break;
            case 2:
                data.add(new TradeModel("2021/01/11","KOSDAQ","애플",12360,3,1239300));
                data.add(new TradeModel("2021/01/11","KOSDAQ","마소",12360,3,1239300));
                data.add(new TradeModel("2021/01/11","KOSDAQ","ETVZ",12360,3,1239300));
                break;
            case 3:
                for(int i=0;i<6;i++)
                    data.add(new TradeModel());
                break;
        }


        return data;

    }
}
