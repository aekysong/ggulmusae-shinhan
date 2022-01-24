package com.example.ggulmusae_shinhan.model;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import com.example.ggulmusae_shinhan.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    private static ArrayList<HashMap<String, String>> readCsvData(Context context) {
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        try {
            InputStream is = context.getResources().openRawResource(R.raw.shinhan_ggulmusae_db);
            BufferedReader input =  new BufferedReader(new InputStreamReader(is), 1024*8);

            try {
                String line = null;
                ArrayList<String> headers = new ArrayList<>();

                while (( line = input.readLine()) != null){
                    String[] items = line.split(",");
                    HashMap<String, String> row = new HashMap<>();

                    if (items[0].equals("id")) {
                        headers.addAll(Arrays.asList(items));
                    }
                    else {
                        for (int i = 0; i < items.length; i++) {
                            row.put(headers.get(i), items[i]);
                            Log.d(TAG, "readCsvData: " + headers.get(i) + " / " + row.get(headers.get(i)));
                        }
                        result.add(row);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                input.close();
            }
        }
        catch (FileNotFoundException ex) {
            Log.e(TAG, "Couldn't find the file.");
            return null;
        }
        catch (IOException ex){
            Log.e(TAG, "Error reading file.");
            return null;
        }

        return result;
    }

    // Dummy Data
    // type : 1 - 사지말껄, 2 - 팔지말껄, 3 - 잘했어
    public static ArrayList<TradeModel> createTradeDummyData(Context context, int type){
        ArrayList<TradeModel> data = new ArrayList<>();
        ArrayList<HashMap<String, String>> dummyDb = readCsvData(context);

        switch (type){
            case 1:
                for (HashMap<String, String> row : dummyDb) {
                    if (row.get("invest_type").equals("사지말껄")) {
                        data.add(new TradeModel(row.get("trade_date"),row.get("market"),row.get("stock"),Integer.parseInt(row.get("trade_price")),Integer.parseInt(row.get("count")),Integer.parseInt(row.get("profit"))));
                    }
                }
                break;
            case 2:
                for (HashMap<String, String> row : dummyDb) {
                    if (row.get("invest_type").equals("팔지말껄")) {
                        data.add(new TradeModel(row.get("trade_date"),row.get("market"),row.get("stock"),Integer.parseInt(row.get("trade_price")),Integer.parseInt(row.get("count")),Integer.parseInt(row.get("profit"))));
                    }
                }
                break;
            case 3:
                for (HashMap<String, String> row : dummyDb) {
                    if (row.get("invest_type").equals("잘했어")) {
                        data.add(new TradeModel(row.get("trade_date"),row.get("market"),row.get("stock"),Integer.parseInt(row.get("trade_price")),Integer.parseInt(row.get("count")),Integer.parseInt(row.get("profit"))));
                    }
                }
                break;
        }

        return data;
    }
}
