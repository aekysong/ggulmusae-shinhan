package com.example.ggulmusae_shinhan.view;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.ggulmusae_shinhan.R;
import com.example.ggulmusae_shinhan.model.TradeModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.w3c.dom.Text;

public class MainBottomSheet extends BottomSheetDialogFragment {

    private View view;
    private TradeModel data;

    public MainBottomSheet(TradeModel data){
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);
        // view.findViewById(R.id.close_btn).setOnClickListener(v -> dismiss());

        ((TextView)view.findViewById(R.id.bs_date)).setText(data.getDate());
        ((TextView)view.findViewById(R.id.bs_date2)).setText(data.getDate());
        ((TextView)view.findViewById(R.id.bs_name)).setText(data.getName());
        ((TextView)view.findViewById(R.id.bs_market)).setText(data.getMarket());
        ((TextView)view.findViewById(R.id.bs_sector)).setText(data.getSector());
        ((TextView)view.findViewById(R.id.bs_trade_type)).setText(data.getTradeType());
        ((TextView)view.findViewById(R.id.bs_invest_type)).setText(data.getInvestType());
        ((TextView)view.findViewById(R.id.bs_count)).setText(data.getCount());
        ((TextView)view.findViewById(R.id.bs_price)).setText(data.getPrice());
        ((TextView)view.findViewById(R.id.bs_price_after_n)).setText(data.getTradePriceAfterN());
        ((TextView)view.findViewById(R.id.bs_total_profit)).setText(data.getProfit());
        ((TextView)view.findViewById(R.id.bs_profit_per_stock)).setText(data.getProfitPerStock());
        ((TextView)view.findViewById(R.id.bs_analyze)).setText(data.getAnalyze());
        if(data.getInvestType().equals("팔지말껄!!")){
            ((TextView)view.findViewById(R.id.bs_regret)).setText("그때 안 팔았으면");
            ((TextView)view.findViewById(R.id.bs_invest_type)).setTextAppearance(R.style.row_text_big_bold_red);
            ((TextView)view.findViewById(R.id.bs_total_profit)).setTextAppearance(R.style.row_text_mid_red_bold);
            ((TextView)view.findViewById(R.id.bs_profit_per_stock)).setTextAppearance(R.style.row_text_mid_red_bold);
            ((TextView)view.findViewById(R.id.bs_advise)).setText("흔들리지 않고 시장을 관망하는 자세를 가져보는건 어떨까요?");
        }
        else if(data.getInvestType().equals("사지말껄!!")){
            ((TextView)view.findViewById(R.id.bs_regret)).setText("그때 안 샀으면");
            ((TextView)view.findViewById(R.id.bs_invest_type)).setTextAppearance(R.style.row_text_big_bold_blue);
            ((TextView)view.findViewById(R.id.bs_total_profit)).setTextAppearance(R.style.row_text_mid_blue_bold);
            ((TextView)view.findViewById(R.id.bs_profit_per_stock)).setTextAppearance(R.style.row_text_mid_blue_bold);
            ((TextView)view.findViewById(R.id.bs_advise)).setText("때가 올 때까지 기다리는 자가 승리한다고 합니다. 다음에는 조금 신중하게 매수하는 것이 어떨까요?");
        }




        return view;

    }
}
