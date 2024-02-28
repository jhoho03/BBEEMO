package com.example.bbeemo_final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class receiveMessageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> userArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
//    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("데이터 불러오는중...");
//        progressDialog.show();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        myAdapter = new MyAdapter(receiveMessageActivity.this,userArrayList);

        recyclerView.setAdapter(myAdapter);

        EventChangeListener();

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
                Intent intent = new Intent(receiveMessageActivity.this, MainActivity.class);
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
                Intent intent = new Intent(receiveMessageActivity.this, threeActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(0, 0);
            }
        });
    }

    private void EventChangeListener() {

        db.collection("users").orderBy("date", Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null) {

                            Log.e("firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()) {

                            if (dc.getType() == DocumentChange.Type.ADDED ) {
                                userArrayList.add(dc.getDocument().toObject(User.class));
                            }
                        }

                        myAdapter.notifyDataSetChanged();


                    }
                });
    }
}