package com.example.bbeemo_final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bbeemo_final.databinding.ActivitySendToBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class sendToActivity extends AppCompatActivity {


    Button btn1;

    Button btn2;

    ImageButton btn3;
    Button btn4;
    Button btn5;

    TextView eoutput1;
    String answer="";
    static  String completeString="";


    private FirebaseFirestore db;
//    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("message/users");

    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySendToBinding binding = ActivitySendToBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = FirebaseAuth.getInstance().getCurrentUser();

        initializeCloudFirestore();


        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);




        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        TextView text_to = (TextView) findViewById(R.id.text_to);
        text_to.setText("TO. " + email);

        Button send_to_btn = (Button) findViewById(R.id.send_to_btn);

        send_to_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        addData();
//                        Toast.makeText(getApplicationContext(), "성공적으로 삐삐를 보냈습니다.", Toast.LENGTH_LONG).show();
//                    }
//                }).start();
                addData();
                Toast.makeText(getApplicationContext(), "성공적으로 삐삐를 보냈습니다.", Toast.LENGTH_LONG).show();
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
                Intent intent = new Intent(sendToActivity.this, MainActivity.class);
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
                Intent intent = new Intent(sendToActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });


        eoutput1= findViewById(R.id.answer);




        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = answer.concat(".");




                completeString = completeString.concat(".");

                if (eoutput1 != null) {
                    eoutput1.setText(answer);
                }


            }
        });


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = answer.concat("-");
                completeString=completeString.concat("-");





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


                                        if (eoutput1 != null) {
                                            eoutput1.setText(answer);


                                        }
                                    }
                                }


        );

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int check = 0;


                completeString = completeString.concat(" ");

                answer = answer.concat(" ");






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





                                    }
                                }
        );

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



    private void initializeCloudFirestore() {
        // Access a Cloud Firestore instance from your Activity
        db = FirebaseFirestore.getInstance();
    }

    private void addData() {
        CollectionReference users = db.collection("users");



        String editText_send = completeString;

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");


        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = ts;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);



        if (editText_send.isEmpty()) { return; }
        Map<String, Object> data1 = new HashMap<>();
        data1.put("msg", editText_send);
        data1.put("email", email);
        data1.put("date", str);
        data1.put("from", user.getEmail());
        users.document(email + (int) (Math.random()*100) ).set(data1);


        Log.d("msg", "메세지가 정상적으로 저장되었습니다.");
        onBackPressed();

//        users.set(data1).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Log.d("msg", "메세지가 정상적으로 저장되었습니다.");
//                    Toast.makeText(sendToActivity.this, "성공적으로 삐삐를 보냈습니다.", Toast.LENGTH_LONG).show();
//                    onBackPressed();
//                }
//                else {
//                    Log.d("msg", "메세지가 저장되지 않았습니다.");
//                    Toast.makeText(sendToActivity.this, "삐삐 오류", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

}