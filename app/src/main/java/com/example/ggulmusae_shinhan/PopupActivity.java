package com.example.ggulmusae_shinhan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity {

    ImageView imageview_celebrity;
    TextView textview_celebrity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup);

        imageview_celebrity = findViewById(R.id.celebrity_image);
        textview_celebrity = findViewById(R.id.celebrity_name);

        int random = (int)((Math.random()*10000)%10) %2;

        switch(random){
            case 0:
                imageview_celebrity.setImageResource(R.drawable.warren1);
                textview_celebrity.setText("워렌 버핏");
                break;
            case 1:
                imageview_celebrity.setImageResource(R.drawable.charles);
                textview_celebrity.setText("찰스 멍거");
//            case 2:
//                imageview_celebrity.setImageResource(R.drawable.peter);
//                textview_celebrity.setText("피터 린치");
        }


    }

    //확인 버튼 클릭
    public void OnClick(View v){
        //액티비티(팝업) 닫기
        switch (v.getId()){
            case R.id.btnclose:
                this.finish();
                break;
            case R.id.share:
                this.finish();
                break;
            case R.id.go_invest_plus:
                this.finish();
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }


}
