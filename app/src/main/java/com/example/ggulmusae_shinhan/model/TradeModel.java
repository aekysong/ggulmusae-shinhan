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
    String sector = "금융업";
    String tradeType = "매수";
    String investType = "사지말껄";
    String sectorTendency = "하락";
    int price = 3250;
    int count = 7;
    int profit = -12500;
    int tradePriceAfterN = 0;
    int profitPerStock = 0;
    DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");

    TradeModel(){}

    TradeModel(String date, String market, String name, String sector, String tradeType, String investType, String sectorTendency, int price, int count, int profit, int tradePriceAfterN, int profitPerStock){
        this.date = date;
        this.market = market;
        this.name = name;
        this.price = price;
        this.count = count;
        this.profit = profit;
        this.sector = sector;
        this.tradePriceAfterN = tradePriceAfterN;
        this.investType = investType;
        this.tradeType = tradeType;
        this.profitPerStock = profitPerStock;
        this.sectorTendency = sectorTendency;
    }

    public String getCount() {
        return "*"+count+"주";
    }

    public String getPrice() {
        return formatter.format(price)+"원";
    }

    public String getProfit() {
        return formatter.format(Math.abs(profit))+"원";
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

    public String getTradePriceAfterN() {
        return formatter.format(tradePriceAfterN)+"원";
    }

    public String getInvestType() {
        return investType+"!!";
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getSector() {
        return sector;
    }

    public String getProfitPerStock() {
        StringBuffer sb = new StringBuffer();
        if(profitPerStock > 0)
            sb.append("+");
        sb.append(formatter.format(profitPerStock)).append("원");
        return sb.toString();
    }

    public String getSectorTendency() {
        return sectorTendency;
    }

    public String getAnalyze(){
        StringBuffer sb = new StringBuffer();
        sb.append(getName())
                .append("는(은) ").append(getTradeType())
                .append("날짜 이후로 10일간 꾸준히 ").append(getSectorTendency()).append("했습니다.\n")
                .append(getName()).append("가(이) 포함된 ").append(getMarket()).append(" ").append(getSector())
                .append("는(은) 평균적으로 ").append(getSectorTendency()).append("하는 국면입니다.");

        return sb.toString();
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
                        data.add(new TradeModel(
                                row.get("trade_date"),
                                row.get("market"),
                                row.get("stock"),
                                row.get("sector"),
                                row.get("trade_type"),
                                row.get("invest_type"),
                                row.get("sector_tendency"),
                                Integer.parseInt(row.get("trade_price")),
                                Integer.parseInt(row.get("count")),
                                Integer.parseInt(row.get("total_profit")),
                                Integer.parseInt(row.get("trade_price_after_n")),
                                Integer.parseInt(row.get("profit_per_stock")))
                        );
                    }
                }
                break;
            case 2:
                for (HashMap<String, String> row : dummyDb) {
                    if (row.get("invest_type").equals("팔지말껄")) {
                        data.add(new TradeModel(
                                row.get("trade_date"),
                                row.get("market"),
                                row.get("stock"),
                                row.get("sector"),
                                row.get("trade_type"),
                                row.get("invest_type"),
                                row.get("sector_tendency"),
                                Integer.parseInt(row.get("trade_price")),
                                Integer.parseInt(row.get("count")),
                                Integer.parseInt(row.get("total_profit")),
                                Integer.parseInt(row.get("trade_price_after_n")),
                                Integer.parseInt(row.get("profit_per_stock")))
                        );
                    }
                }
                break;
            case 3:
                for (HashMap<String, String> row : dummyDb) {
                    if (row.get("invest_type").equals("잘했어")) {
                        data.add(new TradeModel(
                                row.get("trade_date"),
                                row.get("market"),
                                row.get("stock"),
                                row.get("sector"),
                                row.get("trade_type"),
                                row.get("invest_type"),
                                row.get("sector_tendency"),
                                Integer.parseInt(row.get("trade_price")),
                                Integer.parseInt(row.get("count")),
                                Integer.parseInt(row.get("total_profit")),
                                Integer.parseInt(row.get("trade_price_after_n")),
                                Integer.parseInt(row.get("profit_per_stock")))
                        );
                    }
                }
                break;
        }

        return data;
    }
}
