package com.example.bbeemo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbeemo_final.databinding.ActivityMosengletterchangeBinding;
import com.example.bbeemo_final.databinding.ActivityMosletterchangeBinding;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mosengletterchange extends AppCompatActivity {

    ActivityMosengletterchangeBinding binding;
    String answer = "";
    String correct = "";

    String middleletter="";

    String letter="";

    TextView eoutput1;
    TextView eoutput2;


    TextView eoutput3;

    String completeString="";


    Button btn1;
    Button btn2;
    ImageButton btn3;
    Button btn4;
    Button btn5;
    Button btn6;



    Button letterchange;
    ImageButton morsechange;


    int chonum;
    int joongnum=-1;
    int jongnum;

    ImageButton dialogbutton;

    String[] list = {"", "", ""};
    String correctword = "";
    String koroutbuffer = "";
    String korout = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


     super.onCreate(savedInstanceState);


    binding = ActivityMosengletterchangeBinding.inflate(getLayoutInflater());




    setContentView(binding.getRoot());
    // 바텀게이션바 이미지버튼 3개
    ImageButton translate_btn = (ImageButton) findViewById(R.id.ic_translate);
    ImageButton bbeemo_btn = (ImageButton) findViewById(R.id.ic_bbeemo);
    ImageButton problemsolving_btn = (ImageButton) findViewById(R.id.ic_problemsolving);


    // 바텀네비게이션바 클릭 이벤트
        translate_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 무응답
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
            Intent intent = new Intent(getApplicationContext(), threeActivity.class);
            startActivity(intent);
            finish();

            overridePendingTransition(0, 0);
        }
    });


    btn1 = findViewById(R.id.button1);
    btn2 = findViewById(R.id.button2);
    btn3 = findViewById(R.id.button3);
    btn4 = findViewById(R.id.button4);
    btn5 = findViewById(R.id.button5);
    btn6 = findViewById(R.id.button6);

    eoutput1 = findViewById(R.id.answer);

    eoutput2 = findViewById(R.id.korout);


    //eoutput3=findViewById(R.id.middleout);


    morsechange = findViewById(R.id.morsechange);



        // initializing string arrays
        final String[] AlphaNumeric = new String[37];

        // string array for storing alphabets and numbers
        final String[] AlphaNumeric1 = new String[37];

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
        AlphaNumeric[26] = "0";
        AlphaNumeric[27] = "1";
        AlphaNumeric[28] = "2";
        AlphaNumeric[29] = "3";
        AlphaNumeric[30] = "4";
        AlphaNumeric[31] = "5";
        AlphaNumeric[32] = "6";
        AlphaNumeric[33] = "7";
        AlphaNumeric[34] = "8";
        AlphaNumeric[35] = "9";
        AlphaNumeric[36] = " ";

        // assigning the corresponding morse code
        // for each letter and number to
        // Alphanumeric1[] array
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
        AlphaNumeric1[26] = "-----";
        AlphaNumeric1[27] = ".----";
        AlphaNumeric1[28] = "..---";
        AlphaNumeric1[29] = "...--";
        AlphaNumeric1[30] = "....-";
        AlphaNumeric1[31] = ".....";
        AlphaNumeric1[32] = "-....";
        AlphaNumeric1[33] = "--...";
        AlphaNumeric1[34] = "---..";
        AlphaNumeric1[35] = "----.";


        // 번역표 다이얼로그
        dialogbutton = (ImageButton) findViewById(R.id.trans_dialog);
        dialogbutton.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {


                                                android.app.Dialog builder = new android.app.Dialog(mosengletterchange.this);
                                                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                                builder.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
                                                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                    @Override
                                                    public void onDismiss(DialogInterface dialogInterface) {
                                                    }
                                                });
                                                ImageView imageView = new ImageView(mosengletterchange.this);
                                                imageView.setImageResource(R.drawable.trans_table); // img1은 이미지의 아이디
                                                builder.addContentView(imageView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                                                builder.show();
                                            }
                                        }
        );



        morsechange.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mosIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mosIntent);
            finish();

        }
    });


        btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answer = answer.concat(".");
            letter = letter.concat(".");
            correctword = correctword.concat(".");


            completeString = completeString.concat(".");

            if (eoutput1 != null) {
                eoutput1.setText(answer);
            }


        }
    });
        btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answer = answer.concat("-");
            letter = letter.concat("-");
            correctword = correctword.concat("-");


            completeString = completeString.concat("-");
            if (eoutput1 != null) {
                eoutput1.setText(answer);


            }
        }
    });


        btn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            completeString = removeLastChar(completeString);

            answer=removeLastChar(answer);
            eoutput1.setText(answer);

            /*if (String.valueOf(answer.charAt(answer.length() - 1)).equals("/") &&
                                                (String.valueOf(answer.charAt(answer.length() - 2)).equals("/"))) {
                                            korout = removeLastChar(korout);

                                            correctword = removeLastChar(correctword);
                                            correctword = removeLastChar(correctword);


                                        } else if (String.valueOf(answer.charAt(answer.length() - 1)).equals("/")) {
                                            korout = removeLastChar(korout);
                                            korout = removeLastChar(korout);
                                            answer = removeLastChar(answer);
                                            correctword = removeLastChar(correctword);
                                            eoutput1.setText(answer);
                                            eoutput3.setText(middleletter);


                                        } else if ((String.valueOf(correctword.charAt(correctword.length() - 1)).equals(" "))) {
                                            //middleletter = removeLastChar(middleletter);
                                            correctword = removeLastChar(correctword);

                                            answer = removeLastChar(answer);


                                            eoutput3.setText(middleletter);
                                        } else {
                                            answer = removeLastChar(answer);
                                            correctword = removeLastChar(correctword);
                                            eoutput1.setText(answer);
                                            //eoutput3.setText(middleletter);
                                        }
                                    }

                answer = removeLastChar(answer);
                correctword=removeLastChar(correctword);
                if(eoutput1!=null) {
                    eoutput1.setText(answer);
                }

                if(eoutput3!=null) {

                    if (String.valueOf(correctword.charAt(correctword.length() - 1)).equals(" ")) {
                        middleletter = removeLastChar(middleletter);
                        eoutput3.setText(middleletter);
                    } else {
                        eoutput3.setText(middleletter);
                    }
                }


                                }*/
        }
    }


                                    );

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            completeString = completeString.concat("/");

            answer = answer.concat("/");
            eoutput1.setText(answer);

            /*if ((String.valueOf(answer.charAt(answer.length() - 1)).equals("/"))) {
                korout = korout.concat(" ");
                answer = answer.concat("/");
                middleletter = middleletter.concat("/");
                //eoutput3.setText(middleletter);
                eoutput1.setText(answer);

            } else {


                answer = answer.concat("/");
                middleletter = middleletter.concat("/");
                //eoutput3.setText(middleletter);
                if (eoutput1 != null) {
                    eoutput1.setText(answer);
                }


                String[] listtest = correctword.split(" ");
                if ((Array.getLength(Arrays.stream(listtest).toArray())) == 2) {
                    list[0] = listtest[0];
                    list[1] = listtest[1];
                    list[2] = "";
                } else if ((Array.getLength((Arrays.stream(listtest).toArray())) == 3)) {
                    list[0] = listtest[0];
                    list[1] = listtest[1];
                    list[2] = listtest[2];
                } else if ((Array.getLength((Arrays.stream(listtest).toArray())) > 3)) {
                    showToast("잘못된 입력입니다.");
                    list[0] = "";
                    list[1] = "";
                    list[2] = "";
                    correctword = "";

                }


                int chocount = 0;
                int jongcount = 0;
                int joongcount = 0;


                for (int i = 0; i < 19; i++) {
                    if (KorNumeric1cho[i].equals(list[0])) {


                        chonum = i;
                        chocount = 1;

                    }


                }

                for (int i = 0; i < 21; i++) {
                    if (KorNumeric1jung[i].equals(list[1])) {
                        joongnum = i;
                        joongcount = 1;

                    }

                }


                for (int i = 0; i < 28; i++) {
                    if (KorNumeric1jong[i].equals(list[2])) {
                        jongnum = i;
                        jongcount = 1;
                    }


                }


                if ((chonum + joongnum + jongnum) == 0) {
                    //showToast("잘못된 입력입니다. 다시입력해주세요 ");
                    correctword = "";

                } else {


                    char uni = (char) ((chonum * 21 + joongnum) * 28 + jongnum + 0xAC00);
                    String uni2 = String.valueOf(uni);
                    korout = korout.concat(uni2);

                    koroutbuffer = koroutbuffer + uni2;
                    correctword = "";

                }


            }*/
        }
    }
        );
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String completetranslation = "";

                String[] completelist1;
                if (completeString == "") {
                    Toast.makeText(getApplicationContext(), "번역할 모스부호를 입력해주세요", Toast.LENGTH_SHORT);
                } else {


                    String[] completelist3;


                    completelist3 = completeString.split("//");
                    for (int k = 0; k < completelist3.length; k++) {



                        String[] completelist2;

                        completelist2 = completelist3[k].split("/");


                        for (int i = 0; i < completelist2.length; i++) {
                            for (int j = 0; j < 36; j++)
                                if (AlphaNumeric1[j].equals(completelist2[i])) {
                                    completetranslation = completetranslation.concat(AlphaNumeric[j]);

                                }
                        }
                        completetranslation = completetranslation.concat(" ");
                    }
                    binding.korout.setText(completetranslation);
                }
            }
        }
        );






        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), mosletterchange.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);

            }
        });

        binding.choicelag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), mosletterchange.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
            }
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