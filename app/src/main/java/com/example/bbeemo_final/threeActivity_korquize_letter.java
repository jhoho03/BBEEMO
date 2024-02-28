package com.example.bbeemo_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbeemo_final.databinding.ActivityThreeKorquizeBinding;
import com.example.bbeemo_final.databinding.ActivityThreeKorquizeLetterBinding;
import com.example.bbeemo_final.databinding.DialogBinding;

public class threeActivity_korquize_letter extends AppCompatActivity {

    int count = 0;
    int countcorrect =0;

    private AlertDialog finishDialog;

    TextView output;


    private AlertDialog alertDialog;

    private String correct ="";






    private String answer="";

    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog == finishDialog&& which ==DialogInterface.BUTTON_POSITIVE)
            {

                Intent intent2 = new Intent(getApplicationContext(), threeActivity.class);
                startActivity(intent2);

            }
            else if(dialog == finishDialog && which == DialogInterface.BUTTON_NEGATIVE)
            {
                //Intent intent = new Intent(getApplicationContext(),threeActivity_korquize_letter.class);
               // startActivity(intent);

            }





        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_korquize_letter);




        ActivityThreeKorquizeLetterBinding binding = ActivityThreeKorquizeLetterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("ok", dialogListener);


        final String[] KorNumeric = new String[26];

        final String[] KorNumeric1 = new String[26];

        KorNumeric[0] = "ㄱ";
        KorNumeric[1] = "ㄴ";

        KorNumeric[2] = "ㄷ";
        KorNumeric[3] = "ㄹ";
        KorNumeric[4] = "ㅁ";
        KorNumeric[5] = "ㅂ";
        KorNumeric[6] = "ㅅ";
        KorNumeric[7] = "ㅇ";
        KorNumeric[8] = "ㅈ";
        KorNumeric[9] = "ㅊ";
        KorNumeric[10] = "ㅋ";
        KorNumeric[11] = "ㅌ";
        KorNumeric[12] = "ㅍ";
        KorNumeric[13] = "ㅎ";
        KorNumeric[14] = "ㅏ";
        KorNumeric[15] = "ㅑ";
        KorNumeric[16] = "ㅓ";
        KorNumeric[17] = "ㅕ";
        KorNumeric[18] = "ㅗ";
        KorNumeric[19] = "ㅛ";
        KorNumeric[20] = "ㅜ";
        KorNumeric[21] = "ㅠ";
        KorNumeric[22] = "ㅡ";
        KorNumeric[23] = "ㅣ";
        KorNumeric[24] = "ㅐ";
        KorNumeric[25] = "ㅔ";


        KorNumeric1[0] = ".-..";
        KorNumeric1[1] = "..-.";
        KorNumeric1[2] = ".---";
        KorNumeric1[3] = "...-";
        KorNumeric1[4] = "--";
        KorNumeric1[5] = ".--";
        KorNumeric1[6] = "--.";
        KorNumeric1[7] = "-.-";
        KorNumeric1[8] = ".--.";
        KorNumeric1[9] = "-.-.";
        KorNumeric1[10] = "-..-";
        KorNumeric1[11] = "--..";
        KorNumeric1[12] = "---";
        KorNumeric1[13] = ".---";
        KorNumeric1[14] = ".";
        KorNumeric1[15] = "..";
        KorNumeric1[16] = "-";
        KorNumeric1[17] = "...";
        KorNumeric1[18] = ".-";
        KorNumeric1[19] = "-.";
        KorNumeric1[20] = "....";

        KorNumeric1[21] = ".-.";
        KorNumeric1[22] = "-..";
        KorNumeric1[23] = ".--";
        KorNumeric1[24] = "-.--";
        KorNumeric1[25] = "--.-";





        int[] n= new int[20];
        for(int i=0; i<20; i++)
        {
            n[i]=(int)(Math.random()*25);
        }



        binding.korout.setText(KorNumeric[n[count]]);
        correct=KorNumeric1[n[count]];






        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=answer.concat(".");
                binding.answer.setText(answer);


            }
        });



        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=answer.concat("-");
                binding.answer.setText(answer);



            }
        });


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=removeLastChar(answer);
                binding.answer.setText(answer);



            }
        });


        binding.button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                count++;
                if(correct.equals(answer))
                {


                    countcorrect++;

                    Toast toast=
                            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                    ImageView correctimage=new ImageView(getApplicationContext());
                    correctimage.setImageResource(R.drawable.correcticon);
                    toast.setView(correctimage);
                    //위치 지정
                    toast.setGravity(Gravity.CENTER,50,50);
                    //여백 지정
                    toast.setMargin(1000, 1000);
                    toast.show();


                }
                else {

                    Toast toast=
                            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                    ImageView incorrectimage=new ImageView(getApplicationContext());
                    incorrectimage.setImageResource(R.drawable.incorrecticon);
                    toast.setView(incorrectimage);
                    //위치 지정
                    toast.setGravity(Gravity.CENTER,50,50);
                    //여백 지정
                    toast.setMargin(1000, 1000);
                    toast.show();
                }


                answer="";
                binding.answer.setText("");
                binding.korout.setText("");


                binding.scoreout2.setText(countcorrect+"/8");

                if(count!=8) {
                    binding.korout.setText(KorNumeric[n[count]]);
                    correct = KorNumeric1[n[count]];

                }
                else {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String score = countcorrect + "/8";

                            binding.scoreout.setText(score);
                            binding.score.setVisibility(View.VISIBLE);

                        }
                    },2500);




                }


            }

        });




        binding.scorebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.score.setVisibility(View.INVISIBLE);


                Intent intent = new Intent(getApplicationContext() , threeActivity.class);

                startActivity(intent);

            }
        });

        binding.scorebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.score.setVisibility(View.INVISIBLE);
                Intent intent2= new Intent(getApplicationContext(), threeActivity_korquize_letter.class);
                startActivity(intent2);

            }
        });









        binding.button7.setOnClickListener(v -> {


            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View dialogView = inflater.inflate(R.layout.dialog, null);









            finishDialog = new AlertDialog.Builder(this)

                    .setTitle("정말로 나가시겠습니까?")
                    .setPositiveButton("나가기",dialogListener)
                    .setNegativeButton("취소",dialogListener)


                    .create();
            finishDialog.show();







        });



























    }




    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }

}







