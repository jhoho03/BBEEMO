package com.example.bbeemo_final;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbeemo_final.databinding.ActivityMosletterchangeBinding;
import com.google.common.base.MoreObjects;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mosletterchange extends AppCompatActivity {

    ActivityMosletterchangeBinding binding;
    String answer = "";
    String correct = "";

    String middleletter="";

    String letter="";

    TextView eoutput1;
    TextView eoutput2;

    ImageButton dialogbutton;
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


    String[] list = {"", "", ""};
    String correctword = "";
    String koroutbuffer = "";
    String korout = "";







    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMosletterchangeBinding.inflate(getLayoutInflater());




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


        final String[] Cho = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ",
                "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
        final String[] Jung = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ",
                "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"
        };
        final String[] Jong = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ",
                "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"
        };


        final String[] KorNumericcho = new String[26];


        final String[] KorNumeric1cho = new String[19];
        final String[] KorNumeric1jung = new String[21];
        final String[] KorNumeric1jong = new String[28];


        KorNumeric1cho[0] = ".-..";
        KorNumeric1cho[1] = ".-...-..";
        KorNumeric1cho[2] = "..-.";
        KorNumeric1cho[3] = "-...";
        KorNumeric1cho[4] = "-...-...";
        KorNumeric1cho[5] = "...-";
        KorNumeric1cho[6] = "--";
        KorNumeric1cho[7] = ".--";
        KorNumeric1cho[8] = ".--.--";
        KorNumeric1cho[9] = "--.";
        KorNumeric1cho[10] = "--.--.";
        KorNumeric1cho[11] = "-.-";
        KorNumeric1cho[12] = ".--.";
        KorNumeric1cho[13] = ".--..--.";
        KorNumeric1cho[14] = "-.-.";
        KorNumeric1cho[15] = "-..-";
        KorNumeric1cho[16] = "--..";
        KorNumeric1cho[17] = "---";
        KorNumeric1cho[18] = ".---";

        KorNumeric1jung[0] = ".";
        KorNumeric1jung[1] = "--.-";
        KorNumeric1jung[2] = "..";
        KorNumeric1jung[3] = "....-";
        KorNumeric1jung[4] = "-";
        KorNumeric1jung[5] = "-.--";
        KorNumeric1jung[6] = "...";
        KorNumeric1jung[7] = ".....-";
        KorNumeric1jung[8] = ".-";
        KorNumeric1jung[9] = ".-.";
        KorNumeric1jung[10] = ".---.-";
        KorNumeric1jung[11] = ".-..-";
        KorNumeric1jung[12] = "-.";
        KorNumeric1jung[13] = "....";
        KorNumeric1jung[14] = "....-";
        KorNumeric1jung[15] = "....-.--";
        KorNumeric1jung[16] = "......-";
        KorNumeric1jung[17] = ".-.";
        KorNumeric1jung[18] = "-..";
        KorNumeric1jung[19] = "-...-";
        KorNumeric1jung[20] = "..-";


        KorNumeric1jong[0] = "";
        KorNumeric1jong[1] = ".-..";
        KorNumeric1jong[2] = ".-...-..";
        KorNumeric1jong[3] = ".-..--.";
        KorNumeric1jong[4] = "..-.";
        KorNumeric1jong[5] = "..-..--.";
        KorNumeric1jong[6] = "..-..---";
        KorNumeric1jong[7] = "-...";
        KorNumeric1jong[8] = "...-";
        KorNumeric1jong[9] = "...-.-..";
        KorNumeric1jong[10] = "...---";
        KorNumeric1jong[11] = "...-.--";
        KorNumeric1jong[12] = "...---.";
        KorNumeric1jong[13] = "...-..--";
        KorNumeric1jong[14] = "...----";
        KorNumeric1jong[15] = "...-.---";
        KorNumeric1jong[16] = "--";
        KorNumeric1jong[17] = ".--";
        KorNumeric1jong[18] = ".----.";
        KorNumeric1jong[19] = "--.";
        KorNumeric1jong[20] = "--.--.";
        KorNumeric1jong[21] = "-.-";
        KorNumeric1jong[22] = ".--.";
        KorNumeric1jong[23] = "-.-.";
        KorNumeric1jong[24] = "-..-";
        KorNumeric1jong[25] = "--..";
        KorNumeric1jong[26] = "---";
        KorNumeric1jong[27] = ".---";


        // 번역표 다이얼로그
        dialogbutton = (ImageButton) findViewById(R.id.trans_dialog);
        dialogbutton.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {


                                                android.app.Dialog builder = new android.app.Dialog(mosletterchange.this);
                                                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                                builder.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
                                                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                    @Override
                                                    public void onDismiss(DialogInterface dialogInterface) {
                                                    }
                                                });
                                                ImageView imageView = new ImageView(mosletterchange.this);
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

                int check = 0;


                completeString = completeString.concat(" ");

                answer = answer.concat(" ");


                for (int i = 0; i < 19; i++) {
                    if ((letter.equals(KorNumeric1cho[i])) && (check == 0)) {

                        middleletter = middleletter.concat(Cho[i]);
                        //eoutput3.setText(middleletter);
                        check = 1;

                    }
                }
                for (int i = 0; i < 21; i++) {
                    if ((letter.equals(KorNumeric1jung[i])) && (check == 0)) {
                        middleletter = middleletter.concat(Jung[i]);
                        //eoutput3.setText(middleletter);
                        check = 1;

                    }
                }
                for (int i = 0; i < 28; i++) {
                    if ((letter.equals(KorNumeric1jong[i])) && (check == 0)) {
                        middleletter = middleletter.concat(Jong[i]);
                        //eoutput3.setText(middleletter);
                        check = 1;


                    }
                }

                letter = "";


                correctword = correctword.concat(" ");
                if (eoutput1 != null) {
                    eoutput1.setText(answer);

                }

            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        completeString = completeString.concat("/");


                                        answer=answer.concat("/");
                                        binding.answer.setText(answer);




                                       /* if ((String.valueOf(answer.charAt(answer.length() - 1)).equals("/"))) {
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
                completelist1 = completeString.split("//");
                String[] completelist3;

                for (int j = 0; j < completelist1.length; j++) {
                    completelist3 = completelist1[j].split("/");
                    for (int k = 0; k < completelist3.length; k++) {


                        String[] completelist2;

                        completelist2 = completelist3[k].split(" ");


                        if ((Array.getLength(Arrays.stream(completelist2).toArray())) == 2) {
                            list[0] = completelist2[0];
                            list[1] = completelist2[1];
                            list[2] = "";
                        } else if ((Array.getLength((Arrays.stream(completelist2).toArray())) == 3)) {
                            list[0] = completelist2[0];
                            list[1] = completelist2[1];
                            list[2] = completelist2[2];
                        } else if ((Array.getLength((Arrays.stream(completelist2).toArray())) == 1)) {

                            list[0] = completelist2[0];
                            list[1] = "";
                            list[2] = "";
                        } else {

                            list[0] = "";
                            list[1] = "";
                            list[2] = "";
                            correctword = "";

                        }


                        int chocount = 0;
                        int jongcount = 0;
                        int joongcount = 0;

                        chonum = 0;
                        int chonum2=1;


                        for (int i = 0; i < 19; i++) {

                            if (KorNumeric1cho[i].equals(list[0])) {


                                chonum = i;
                                chonum2=1;
                                chocount = 1;

                            }


                        }
                        if(chonum2 !=1)
                        {

                            chonum=-1;
                        }


                        for (int i = 0; i < 21; i++) {
                            if (KorNumeric1jung[i].equals(list[1])) {
                                joongnum = i;
                                joongcount = 1;

                            } else if (list[1] == "") {
                                joongnum = -1;

                            }
                        }


                        for (int i = 0; i < 28; i++) {
                            if (KorNumeric1jong[i].equals(list[2])) {
                                jongnum = i;
                                jongcount = 1;
                            }


                        }


                        if (chonum == -1) {
                            Toast.makeText(getApplicationContext(), list[0], Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), mosletterchange.class);
                            startActivity(intent);


                        } else if (joongnum == -1) {
                            completetranslation = completetranslation.concat(Cho[chonum]);
                            joongnum = 0;

                        } else {

                            char uni = (char) ((chonum * 21 + joongnum) * 28 + jongnum + 0xAC00);
                            String uni2 = String.valueOf(uni);


                            completetranslation = completetranslation.concat(uni2);

                            list[0] = "";
                            list[1] = "";
                            list[2] = "";
                            koroutbuffer = koroutbuffer + uni2;
                            correctword = "";
                        }


                        list[0] = "";
                        list[1] = "";
                        list[2] = "";
                    }


                    completetranslation = completetranslation.concat(" ");
                }


                binding.korout.setText(completetranslation);


            }





        });





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
                Intent intent4 = new Intent(getApplicationContext(), mosengletterchange.class);
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


