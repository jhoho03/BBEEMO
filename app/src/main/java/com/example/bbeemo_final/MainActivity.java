package com.example.bbeemo_final;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    TextView etoutput;
    EditText etinput;
    //EditText etoutput;

    Button engbtnEncode,
            korbtnEncode,
            engbtnDecode,
            korbtnDecode,
            btnclear;


    ImageButton letterchange;

    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 번역표 다이얼로그
        final ImageButton dialogbutton = (ImageButton) findViewById(R.id.trans_dialog);
        dialogbutton.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {


                                                android.app.Dialog builder = new android.app.Dialog(MainActivity.this);
                                                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                                builder.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
                                                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                    @Override
                                                    public void onDismiss(DialogInterface dialogInterface) {
                                                    }
                                                });
                                                ImageView imageView = new ImageView(MainActivity.this);
                                                imageView.setImageResource(R.drawable.trans_table); // img1은 이미지의 아이디
                                                builder.addContentView(imageView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                                                builder.show();
                                            }
                                        }
        );

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
                Intent intent = new Intent(MainActivity.this, twoActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });

        problemsolving_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });






            // Assign variables

            button = findViewById(R.id.changebutton);

            etinput = findViewById(R.id.etinput);

            etinput.setWidth(200);
            //etinput.setText("Katou", TextView.BufferType.NORMAL);
            etinput.setPadding(30, 30, 30, 30);

            //etoutput = findViewById(R.id.etoutput);
            //engbtnDecode = findViewById(R.id.engbtndecode);
           // korbtnDecode = findViewById(R.id.korbtndecode);

            engbtnEncode = findViewById(R.id.engbtnencode);
            korbtnEncode = findViewById(R.id.korbtnencode);
            btnclear = findViewById(R.id.btnclear);

            letterchange = findViewById(R.id.letterchange);


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
            AlphaNumeric1[36] = "/";


            final String[] KorNumeric = new String[51];

            final String[] KorNumeric1 = new String[51];

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

            KorNumeric[26] = "ㄲ";
            KorNumeric[27] = "ㄸ";
            KorNumeric[28] = "ㅃ";
            KorNumeric[29] = "ㅆ";
            KorNumeric[30] = "ㅉ";

            KorNumeric[31] = "ㅒ";
            KorNumeric[32] = "ㅖ";
            KorNumeric[33] = "ㅘ";
            KorNumeric[34] = "ㅙ";
            KorNumeric[35] = "ㅚ";
            KorNumeric[36] = "ㅝ";
            KorNumeric[37] = "ㅞ";
            KorNumeric[38] = "ㅟ";
            KorNumeric[39] = "ㅢ";

            KorNumeric[40] = "ㄳ";
            KorNumeric[41] = "ㄵ";
            KorNumeric[42] = "ㄶ";
            KorNumeric[43] = "ㄺ";
            KorNumeric[44] = "ㄻ";
            KorNumeric[45] = "ㄼ";
            KorNumeric[46] = "ㄽ";
            KorNumeric[47] = "ㄾ";
            KorNumeric[48] = "ㅀ";
            KorNumeric[49] = "ㅄ";
            KorNumeric[50] = " ";

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

            KorNumeric1[26] = ".-.. .-..";
            KorNumeric1[27] = ".-.. .-..";
            KorNumeric1[28] = ".-- .--";
            KorNumeric1[29] = "--. --.";
            KorNumeric1[30] = ".--. .--.";
            KorNumeric1[31] = ".. ..-";
            KorNumeric1[32] = "··· ··–";
            KorNumeric1[33] = ".- .";
            KorNumeric1[34] = ".- --.-";
            KorNumeric1[35] = ".- ..-";
            KorNumeric1[36] = ".... -";
            KorNumeric1[37] = ".... -.--";
            KorNumeric1[38] = ".... ..-";
            KorNumeric1[39] = "-.. ..-";
            KorNumeric1[40] = ".-.. --.";
            KorNumeric1[41] = "..-. .--.";
            KorNumeric1[42] = "..-. .---";
            KorNumeric1[43] = "...- .-..";
            KorNumeric1[44] = "...- --";
            KorNumeric1[45] = "...- .--";
            KorNumeric1[46] = "...- --.";
            KorNumeric1[47] = "...- --..";
            KorNumeric1[48] = "...- .---";
            KorNumeric1[49] = ".-- --.";
            KorNumeric1[50] = "/";



            letterchange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,mosletterchange.class);

                    startActivity(intent);


                }
            });



            // mosletterFragment로 이동 // 액티비티로 변환할것
           /* letterchange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Log", "Clicked");
                    //startActivity(new Intent(FavoritesActivity.this, mosletterFragment.class));
                }
            });*/


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Log", "Clicked");

                    etinput.setText("");
                    //etoutput.setText("");


                    if (korbtnEncode.getVisibility() == View.INVISIBLE) {
                        korbtnEncode.setEnabled(true);
                        korbtnEncode.setVisibility(View.VISIBLE);
                        etinput.setHint("번역할 한국어를 입력하세요");
                    } else if (korbtnEncode.getVisibility() == View.VISIBLE) {
                        korbtnEncode.setEnabled(false);
                        korbtnEncode.setVisibility(View.INVISIBLE);
                        etinput.setHint("번역할 영어를 입력하세요");
                    }
                }
            });


            engbtnEncode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String input = etinput.getText().toString();

                    String output = "";

                    // variable used to compute the output
                    // to get the length of the input string
                    int l = input.length();

                    // variables used in loops
                    int i, j;

                    for (i = 0; i < l; i++) {

                        // to extract each Token of the string at a time
                        String ch = input.substring(i, i + 1);

                        // the loop to check the extracted token with
                        // each letter and store the morse code in
                        // the output variable accordingly
                        for (j = 0; j < 37; j++) {

                            if (ch.equalsIgnoreCase(AlphaNumeric[j])) {

                                // concat space is used to separate
                                // the morse code of each token
                                output = output.concat(AlphaNumeric1[j]).concat(" ");


                            }
                        }
                    }

                    // to display the output
                    //etoutput.setText(output);



                    //결과주기
                    if(output != "") {

                        Intent intent = new Intent(MainActivity.this, SecondFavoritesActivity.class);
                        intent.putExtra("key", output);
                        startActivity(intent); //.putExtra("extra", output));
                    }




                }
            });


            korbtnEncode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String[] CHO = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ",
                            "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};

                    final String[] JOONG = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ",
                            "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};

                    final String[] JONG = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ",
                            "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};


                    // to get the input as string which the user wants to encode
                    String input = etinput.getText().toString();

                    StringBuilder chooutput = new StringBuilder();

                    for (int i = 0; i < input.length(); i++) {
                        char uniVal = input.charAt(i);

                        // 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
                        if (uniVal >= 0xAC00) {
                            uniVal = (char) (uniVal - 0xAC00);

                            char cho = (char) (uniVal / 28 / 21);
                            char joong = (char) ((uniVal) / 28 % 21);
                            char jong = (char) (uniVal % 28);    // 종성의 첫번째는 채움이기 때문에

                            chooutput.append(CHO[cho]).append(JOONG[joong]).append(JONG[jong]);
                        } else {
                            // For non-Korean characters, append the original character
                            chooutput.append(uniVal);
                        }
                    }
                    input = String.valueOf(chooutput);


                    String output = "";

                    // variable used to compute the output
                    // to get the length of the input string
                    int l = input.length();

                    // variables used in loops
                    int i, j;

                    for (i = 0; i < l; i++) {

                        // to extract each Token of the string at a time
                        String ch = input.substring(i, i + 1);

                        // the loop to check the extracted token with
                        // each letter and store the morse code in
                        // the output variable accordingly
                        for (j = 0; j < 51; j++) {

                            if (ch.equalsIgnoreCase(KorNumeric[j])) {

                                // concat space is used to separate
                                // the morse code of each token
                                output = output.concat(KorNumeric1[j]).concat(" ");


                            }
                        }
                    }

                    // to display the output
                    //etoutput.setText(output);



                    //결과주기
                    if(output != "") {

                        Intent intent = new Intent(MainActivity.this, SecondFavoritesActivity.class);
                        intent.putExtra("key", output);
                        startActivity(intent); //.putExtra("extra", output));


                    }

                }

            });


            btnclear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // When button clear is clicked then the
                    // following lines inside this curly
                    // braces will be executed

                    // to clear the etinput
                    etinput.setText("");

                    // to clear etoutput
                    //etoutput.setText("");
                }
            });

            /*
            engbtnDecode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String input1 = etinput.getText().toString();
                    String input = input1.concat(" ");
                    int l = input.length();
                    int i, j, p = 0;
                    int pos = 0;

                    // to store the extracted morse code
                    // for each Alphabet,number or space
                    String letter = "";
                    // a to store the output in it
                    String output = "";

                    for (i = 0; i < l; i++) {

                        // a variable used to trigger the j loop only
                        // when the complete morse code of a letter
                        // or number is extracted
                        int flag = 0;
                        // to extract each token at a time
                        String ch = input.substring(i, i + 1);
                        // if the extracted token is a space
                        if (ch.equalsIgnoreCase(" ")) {
                            // to store the value of i in p
                            p = i;
                            // to extract the morse code for each letter or number
                            letter = input.substring(pos, p);
                            // to update the value of pos so that next
                            // time the morse code for the next letter
                            // or digit is extracted
                            pos = p + 1;
                            flag = 1;
                        }
                        String letter1 = letter.trim();
                        // to delete extra whitespaces at
                        // both ends in case there are any
                        if (flag == 1) {
                            for (j = 0; j <= 36; j++) {
                                if (letter1.equalsIgnoreCase(AlphaNumeric1[j])) {
                                    output = output.concat(AlphaNumeric[j]);
                                    break;
                                }
                            }
                        }
                    }
                    // to display the output
                    etoutput.setText(output);
                }
            });


            korbtnDecode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String input1 = etinput.getText().toString();
                    String input = input1.concat(" ");
                    int l = input.length();
                    int i, j, p = 0;
                    int pos = 0;
                    // to store the extracted morse code
                    // for each Alphabet,number or space
                    String letter = "";
                    // a to store the output in it
                    String output = "";

                    for (i = 0; i < l; i++) {
                        // a variable used to trigger the j loop only
                        // when the complete morse code of a letter
                        // or number is extracted
                        int flag = 0;
                        // to extract each token at a time
                        String ch = input.substring(i, i + 1);
                        // if the extracted token is a space
                        if (ch.equalsIgnoreCase(" ")) {
                            // to store the value of i in p
                            p = i;
                            // to extract the morse code for each letter or number
                            letter = input.substring(pos, p);
                            // to update the value of pos so that next
                            // time the morse code for the next letter
                            // or digit is extracted
                            pos = p + 1;
                            flag = 1;
                        }
                        String letter1 = letter.trim();
                        // to delete extra whitespaces at
                        // both ends in case there are any
                        if (flag == 1) {
                            for (j = 0; j <= 50; j++) {
                                if (letter1.equalsIgnoreCase(KorNumeric1[j])) {
                                    output = output.concat(KorNumeric[j]);
                                    break;
                                }
                            }
                        }
                    }
                    // to display the output
                    etoutput.setText(output);

                }
            });

             */


        }
    }
