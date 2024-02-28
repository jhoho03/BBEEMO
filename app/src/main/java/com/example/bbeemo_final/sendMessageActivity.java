package com.example.bbeemo_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class sendMessageActivity extends AppCompatActivity {

    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        EditText send_email = (EditText) findViewById(R.id.editTextMail);
        Button send_btn = (Button) findViewById(R.id.send_email_btn);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = send_email.getText().toString();

                if (email.length() == 0) {
                    // 공백일때 처리할 내용
                    Toast.makeText(sendMessageActivity.this, "입력칸에 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(sendMessageActivity.this, sendToActivity.class);
                    intent.putExtra("email", email);

                    startActivity(intent);

                }
            }
        });



        ImageButton back_btn = (ImageButton) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
                Intent intent = new Intent(sendMessageActivity.this, MainActivity.class);
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
                Intent intent = new Intent(sendMessageActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });
    }

}