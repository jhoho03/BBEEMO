package com.example.bbeemo_final;

import android.content.Context;
import android.content.Intent;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



//    private OnItemClickListener itemClickListener;
//
//    //인터페이스 선언
//    public interface OnItemClickListener{
//        //클릭시 동작할 함수
//        void onItemClick(View v, int pos);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener){
//        this.itemClickListener = listener;
//    }

    ActivityResultLauncher<Intent> resultLauncher;

    Context context;
    ArrayList<User> userArrayList;


    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_items,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = userArrayList.get(position);

        holder.from.setText("from. " + user.from);
        holder.msg.setText(user.msg);
        holder.date.setText(user.date);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {



        TextView from, msg, date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            from = itemView.findViewById(R.id.from);
            msg = itemView.findViewById(R.id.msg);
            date = itemView.findViewById(R.id.date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    Log.d("recycleClick", "리사이클러뷰에서의 아이템 클릭 진행");
                    String string=msg.getText().toString();
                    String string2=from.getText().toString();
                    String string3=date.getText().toString();

                    Intent intent= new Intent(itemView.getContext(), SecondFavoritesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("key",string);
                    intent.putExtra("key2",string2);
                    intent.putExtra("key3",string3);




                    itemView.getContext().startActivity(intent);





                }
            });
        }
    }
}
