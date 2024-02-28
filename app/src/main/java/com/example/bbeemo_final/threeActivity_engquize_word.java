package com.example.bbeemo_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbeemo_final.databinding.ActivityThreeEngquizeBinding;
import com.example.bbeemo_final.databinding.ActivityThreeEngquizeLetterBinding;
import com.example.bbeemo_final.databinding.ActivityThreeEngquizeWordBinding;

public class threeActivity_engquize_word extends AppCompatActivity {


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

              //  Intent intent = new Intent(getApplicationContext(),threeActivity_engquize_word.class);
              //  startActivity(intent);

            }





        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityThreeEngquizeWordBinding binding = ActivityThreeEngquizeWordBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setPositiveButton("ok",dialogListener);




        final String[] AlphaNumeric = new String[26];

        final String[] AlphaNumeric1 = new String[26];



        AlphaNumeric[0] = "A";
        AlphaNumeric[1] = "B";
        AlphaNumeric[2] = "C";
        AlphaNumeric[3] = "D";
        AlphaNumeric[4] = "E";
        AlphaNumeric[5] = "F";
        AlphaNumeric[6] = "G";
        AlphaNumeric[7] = "H";
        AlphaNumeric[8] = "I";
        AlphaNumeric[9] = "J";
        AlphaNumeric[10] = "K";
        AlphaNumeric[11] = "L";
        AlphaNumeric[12] = "M";
        AlphaNumeric[13] = "N";
        AlphaNumeric[14] = "O";
        AlphaNumeric[15] = "P";
        AlphaNumeric[16] = "Q";
        AlphaNumeric[17] = "R";
        AlphaNumeric[18] = "S";
        AlphaNumeric[19] = "T";
        AlphaNumeric[20] = "U";
        AlphaNumeric[21] = "V";
        AlphaNumeric[22] = "W";
        AlphaNumeric[23] = "X";
        AlphaNumeric[24] = "Y";
        AlphaNumeric[25] = "Z";



        AlphaNumeric1[0] = ".-";
        AlphaNumeric1[1] = "-...";
        AlphaNumeric1[2] = "-.-.";
        AlphaNumeric1[3] = "-..";
        AlphaNumeric1[4] = ".";

        AlphaNumeric1[5] = "..-.";
        AlphaNumeric1[6] = "--.";
        AlphaNumeric1[7] = "....";
        AlphaNumeric1[8] = "..";
        AlphaNumeric1[9] = ".---";
        AlphaNumeric1[10] = "-.-";
        AlphaNumeric1[11] = ".-..";
        AlphaNumeric1[12] = "--";
        AlphaNumeric1[13] = "-.";
        AlphaNumeric1[14] = "---";
        AlphaNumeric1[15] = ".--.";
        AlphaNumeric1[16] = "--.-";
        AlphaNumeric1[17] = ".-.";

        AlphaNumeric1[18] = "...";
        AlphaNumeric1[19] = "-";
        AlphaNumeric1[20] = "..-";
        AlphaNumeric1[21] = "...-";
        AlphaNumeric1[22] = ".--";
        AlphaNumeric1[23] = "-..-";
        AlphaNumeric1[24] = "-.--";
        AlphaNumeric1[25] = "--..";


        int[] n= new int[20];
        for(int i=0; i<20; i++)
        {
            n[i]=(int)(Math.random()*25);
        }



        binding.engout.setText(AlphaNumeric1[n[count]]);
        correct=AlphaNumeric[n[count]];



        binding.correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =binding.edit.getText().toString();
                count++;
                binding.edit.setText("");


                    if(correct.equals(s))
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
                binding.scoreout2.setText(countcorrect+"/8");




                binding.engout.setText("");



                if(count!=8) {
                    binding.engout.setText(AlphaNumeric[n[count]]);
                    correct = AlphaNumeric1[n[count]];

                }
                else {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String score = countcorrect + "/8";

                            binding.edit.setVisibility(View.GONE);
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
                Intent intent2= new Intent(getApplicationContext(),threeActivity_engquize_word.class);
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



