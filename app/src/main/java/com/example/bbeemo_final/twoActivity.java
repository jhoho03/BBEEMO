package com.example.bbeemo_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class twoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ImageButton sign_out_button = (ImageButton) findViewById(R.id.sign_out_button);
        ImageButton cookie_btn = (ImageButton) findViewById(R.id.cookie_btn);
        Button send_btn = (Button) findViewById(R.id.send_btn);
        Button receive_btn = (Button) findViewById(R.id.receive_btn);


        // 바텀게이션바 이미지버튼 3개
        ImageButton translate_btn = (ImageButton) findViewById(R.id.ic_translate);
        ImageButton bbeemo_btn = (ImageButton) findViewById(R.id.ic_bbeemo);
        ImageButton problemsolving_btn = (ImageButton) findViewById(R.id.ic_problemsolving);


        cookie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twoActivity.this, fortuneActivity.class);
                startActivity(intent);

                overridePendingTransition(0, 0);
            }
        });

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twoActivity.this, sendMessageActivity.class);
                startActivity(intent);

                overridePendingTransition(0, 0);
            }
        });

        receive_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twoActivity.this, receiveMessageActivity.class);
                startActivity(intent);

                overridePendingTransition(0, 0);
            }
        });

        ImageButton signOutButton = (ImageButton) findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                finish();
            }
        });




        // 바텀네비게이션바 클릭 이벤트
        translate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twoActivity.this, MainActivity.class);
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
                Intent intent = new Intent(twoActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

    }

    private void signOut() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        Intent intent = new Intent(twoActivity.this, EmailPasswordActivity.class);
        startActivity(intent);
        finish();

        // Check if there is no current user.
        if (firebaseAuth.getCurrentUser() == null)
            Toast.makeText(this.getApplicationContext(), "로그아웃 성공", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this.getApplicationContext(), "로그아웃 실패", Toast.LENGTH_SHORT).show();
    }
}