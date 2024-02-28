package com.example.bbeemo_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fortuneActivity extends AppCompatActivity {
    TextView fortune;

    Button btn1;

    String string1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);





        ImageButton back_btn = (ImageButton) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fortune = findViewById(R.id.fortune);


       string1 = " – · · ·　 – · · ·　 – – · –　 · · · –　 · –　 · · – ·　 – · ·　 · · – ·　　　 – · –　 · ·　 · – · ·　 · – · ·　 ·　 · · – ·　 – · –　 – · ·　 · · –　　　 · – · ·　 · –　 · – – ·　 · · –　 · – –　 – · –　 · · –　　　 – – –　 · · –　 · · · –　 – · –　 – ·　 · – – –　 ·　 · – –　 · · – ·　 · · –　 – · · ·　 ·　 · – · – · –　";
        fortune.setText(string1);














        btn1 = findViewById(R.id.meaning);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                string1 ="때로는 약간의 고집이 필요합니다.";

                fortune.setText(string1);

            }
        });








        // 바텀게이션바 이미지버튼 3개
        ImageButton translate_btn = (ImageButton) findViewById(R.id.ic_translate);
        ImageButton bbeemo_btn = (ImageButton) findViewById(R.id.ic_bbeemo);
        ImageButton problemsolving_btn = (ImageButton) findViewById(R.id.ic_problemsolving);


        // 바텀네비게이션바 클릭 이벤트
        translate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fortuneActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

        bbeemo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 무응답
            }
        });

        problemsolving_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fortuneActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

    }
}