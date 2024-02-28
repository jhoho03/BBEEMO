package com.example.bbeemo_final;


import android.content.Intent;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondFavoritesActivity extends AppCompatActivity {


    private String resultString;
    private TextView morseresult;




    private MediaPlayer dotPlayer;
    private MediaPlayer dashPlayer;
    private MediaPlayer spacePlayer;

    private static Camera mCamera = null;

    private static CameraManager mCameraManager;

    private static boolean mFlashOn = false;

    private String mCameraId;
    private CheckBox beepCheckBox, lightCheckBox, vibeCheckBox;

    ImageButton previous_button;

    private TextView textViewfrom;

    private TextView textViewdate;







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_favorites);

        morseresult = findViewById(R.id.morseresult);


        Intent i = getIntent();
        resultString = i.getStringExtra("key");


        morseresult.setText(getIntent().getStringExtra("key"));


        //resultString.setText(getIntent().getStringExtra("extra"));

        dotPlayer = MediaPlayer.create(this, R.raw.dot_sound);
        dashPlayer = MediaPlayer.create(this, R.raw.dash_sound);
        spacePlayer = MediaPlayer.create(this, R.raw.space_sound);
//        spacePlayer = MediaPlayer.create(requireContext(), R.raw.space_sound);

        textViewfrom=findViewById(R.id.from);
        textViewfrom.setText(i.getStringExtra("key2"));



        textViewdate=findViewById(R.id.date);
        textViewdate.setText(i.getStringExtra("key3"));


        mCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        if (mCameraId == null) {
            try {
                for (String id : mCameraManager.getCameraIdList()) {
                    CameraCharacteristics c = mCameraManager.getCameraCharacteristics(id);
                    Boolean flashAvailable = c.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                    Integer lensFacing = c.get(CameraCharacteristics.LENS_FACING);
                    if (flashAvailable != null && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                        mCameraId = id;
                        break;
                    }
                }
            } catch (CameraAccessException e) {
                mCameraId = null;
                e.printStackTrace();
            }
        }

        //return inflater.inflate(R.layout.fragment_second_favorites, container, false);
        {

            //모스코드 받아온 String
            morseresult = findViewById(R.id.morseresult);

            morseresult.setMovementMethod(new ScrollingMovementMethod());

            // 텍스트뷰 스크롤 !!!!!!!Relative 사용하라는.....
            //TextView morseresult = findViewById(R.id.morseresult);
            //morseresult.setMovementMethod(new ScrollingMovementMethod());
            //zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz

            //체크박스
            beepCheckBox = findViewById(R.id.beepcheckBox);
            lightCheckBox = findViewById(R.id.lightcheckBox);
            vibeCheckBox = findViewById(R.id.vibecheckBox);


            //뒤로가기 버튼
            previous_button = findViewById(R.id.previous);
            previous_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            // 올 펄스면 재생안되기 다 체크로 바꾸기


            //all 버튼
            Button AllButton = findViewById(R.id.all);
            AllButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (beepCheckBox.isChecked() || vibeCheckBox.isChecked() || lightCheckBox.isChecked()) {
                        AllplayMorseCode(resultString);
                    }
                }
            });


//            //플래시 버튼
//            Button FlashButton = findViewById(R.id.light);
//            FlashButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (lightCheckBox.isChecked()) {
//                        lightplayMorseCode(resultString);
//                    }
//                }
//            });
//
//            //진동 버튼
//            Button Vibration = findViewById(R.id.Vibration);
//            Vibration.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (vibeCheckBox.isChecked()) {
//                        vibeplayMorseCode(resultString);
//                    }
//                }
//            });
//
//            //소리 버튼
//            Button beep_button = findViewById(R.id.beep);
//            beep_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (beepCheckBox.isChecked()) {
//                        beepplayMorseCode(resultString);
//                    }
//                }
//            });
        }
    }


    // alll 실행 함수
    private void AllplayMorseCode(String morseCode) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        for (int i = 0; i < morseCode.length()  ; i++) {
            char morseChar = morseCode.charAt(i);
            if (morseChar == '.') {
                if(beepCheckBox.isChecked()){
                    playDot();
                    sleep(90);
                }
                if (vibeCheckBox.isChecked()){
                    vibrator.vibrate(90);
                    sleep(90);
                }
                if (lightCheckBox.isChecked()){
                    flashLightOn();
                    sleep(30);
                    flashLightOff();
                }
                try {
                    Thread.sleep(90); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == '-') {
                if(beepCheckBox.isChecked()){
                    playDash();
                    sleep(150);
                }
                if (vibeCheckBox.isChecked()) {
                    vibrator.vibrate(150);
                    sleep(150);
                }
                if (lightCheckBox.isChecked()) {
                    flashLightOn();
                    sleep(150);
                    flashLightOff();
                }
                try {
                    Thread.sleep(150); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } else if (morseChar == ' ') {
                // Add a delay for spaces (adjust the duration as needed)
                try {
                    Thread.sleep(300); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //light 플래시 함수
    private void lightplayMorseCode(String morseCode) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        for (int i = 0; i < morseCode.length() ; i++) {
            char morseChar = morseCode.charAt(i);
            if (morseChar == '.') {
                flashLightOn();
                sleep(300);
                flashLightOff();
                try {
                    Thread.sleep(300); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == '-') {
                flashLightOn();
                sleep(500);
                flashLightOff();

                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } else if (morseChar == ' ') {
                // Add a delay for spaces (adjust the duration as needed)
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //vibe 진동 함수
    private void vibeplayMorseCode(String morseCode) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        for (int i = 0; i < morseCode.length(); i++) {
            char morseChar = morseCode.charAt(i);
            if (morseChar == '.') {
                vibrator.vibrate(300);
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == '-') {
                vibrator.vibrate(500);
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == ' ') {
                // Add a delay for spaces (adjust the duration as needed)
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //beep 소리 함수
    private void beepplayMorseCode(String morseCode) {
        for (int i = 0; i < morseCode.length() ; i++) {
            char morseChar = morseCode.charAt(i);

            if (morseChar == '.') {
                playDot();
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == '-') {
                playDash();
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (morseChar == ' ') {
                // Add a delay for spaces (adjust the duration as needed)
                try {
                    Thread.sleep(500); // 500 milliseconds delay for space
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // beep 소리 함수
    private void playDot() {
        dotPlayer.start();
    }
    private void playDash() {
        dashPlayer.start();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        dotPlayer.release();
        dashPlayer.release();
        spacePlayer.release();
    }


    //플래시 함수
    public void flashLightOn() {
        mFlashOn = true;
        try {
            mCameraManager.setTorchMode(mCameraId, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public void flashLightOff() {
        mFlashOn = false;
        try {
            mCameraManager.setTorchMode(mCameraId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e){
        }
    }



}
