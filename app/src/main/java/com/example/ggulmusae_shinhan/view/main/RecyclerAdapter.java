package com.example.ggulmusae_shinhan.view.main;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ggulmusae_shinhan.R;
import com.example.ggulmusae_shinhan.model.TradeModel;
import com.example.ggulmusae_shinhan.view.MainBottomSheet;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    Context context;
    ArrayList<TradeModel> list;

    // 프레그먼트 번호에 따라 다른 더미데이터가 생기도록 함.
    RecyclerAdapter(Context context, int fragNum){
        this.context = context;
        list = TradeModel.createTradeDummyData(this.context, fragNum);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new Holder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int pos = position;
        holder.dateTv.setText(list.get(pos).getDate());
        holder.marketTv.setText(list.get(pos).getMarket());
        holder.nameTv.setText(list.get(pos).getName());
        holder.priceTv.setText(list.get(pos).getPrice());   // 원 붙이기
        holder.countTv.setText(list.get(pos).getCount());   // *N주
        holder.profitTv.setText(list.get(pos).getProfit()); // 원 붙이기

        if(list.get(pos).getInvestType().equals("팔지말껄!!")){
            holder.profitTv.setTextAppearance(R.style.row_text_big_red);
        }
        else if(list.get(pos).getInvestType().equals("사지말껄!!")){
            holder.profitTv.setTextAppearance(R.style.row_text_big_blue);
        }else{
            holder.profitTv.setTextAppearance(R.style.row_text_big_yellow);
        }


        holder.view.setOnClickListener(v -> {
            MainBottomSheet bottomSheet = new MainBottomSheet(list.get(position));  // Bottom Sheet 로 현재 Row가 가진 데이터 넘김
            bottomSheet.show(((MainActivity)context).getSupportFragmentManager(), "MainBottomSheet");
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public TextView dateTv, marketTv, nameTv, priceTv, countTv, profitTv;
        public View view;

        public Holder(View view){
            super(view);
            this.view = view;
            dateTv = (TextView) view.findViewById(R.id.row_tv_date);
            marketTv = (TextView) view.findViewById(R.id.row_tv_market);
            nameTv = (TextView) view.findViewById(R.id.row_tv_name);
            priceTv = (TextView) view.findViewById(R.id.row_tv_price_per_one);
            countTv = (TextView) view.findViewById(R.id.row_tv_count);
            profitTv = (TextView) view.findViewById(R.id.row_tv_profit);
            nameTv.setSelected(true);
        }
    }
}
