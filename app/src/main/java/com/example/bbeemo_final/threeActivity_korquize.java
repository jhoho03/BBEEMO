package com.example.bbeemo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bbeemo_final.databinding.ActivityThreeKorquizeBinding;

public class threeActivity_korquize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_korquize);

        ActivityThreeKorquizeBinding binding = ActivityThreeKorquizeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),threeActivity_korquize_letter.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplication(), threeActivity_korquize_word.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent2);
                overridePendingTransition(0, 0);
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

        bbeemo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), twoActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

        problemsolving_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 무응답
            }
        });
    }

    private long time= 0;

    @Override

    public void onBackPressed() {

        super.onBackPressed();
        if (System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis();
            Toast.makeText(this.getApplicationContext(), "한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() - time < 2000) {

            finish();
        }
    }


    }




