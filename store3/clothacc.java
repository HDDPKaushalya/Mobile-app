package com.example.store3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


class datas{
    String color;
    String size;

    public void colors(String color){
        color = this.color;

    }
    public void sizes(String size){
        size = this.size;
    }
    public String setcolor(){
        return color;
    }
    public String setSize(){
        return size;
    }
}

public class clothacc extends AppCompatActivity {

    DatabaseReference store2;

    ImageView ga1,ga1c1,ga1c2,SmallSize,mediamSize,largeSize,xlSize;
    EditText quan;
    Button cartb;
    public int totalnum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothacc);
        ga1 = findViewById(R.id.ga1);
        ga1c1 = findViewById(R.id.ga1c1);
        ga1c2 = findViewById(R.id.ga1c2);
        SmallSize = findViewById(R.id.SmallSize);
        mediamSize = findViewById(R.id.mediamSize);
        largeSize = findViewById(R.id.largeSize);
        xlSize = findViewById(R.id.xlSize);
        quan = findViewById(R.id.quan);
        cartb = findViewById(R.id.cartb);

        datas suss = new datas();


        ga1c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = "Blue";
                suss.colors(color);

            }
        });
        ga1c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = "Red";
                suss.colors(color);
            }
        });
        SmallSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = "Small";
                suss.sizes(size);
            }
        });
        mediamSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = "Mediam";
                suss.sizes(size);
            }
        });

        largeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = "Large";
                suss.sizes(size);
            }
        });
        xlSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = "Xl";
                suss.sizes(size);
            }
        });


        store2 = FirebaseDatabase.getInstance().getReference().child("Orderdcloth");
        cartb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qun = quan.getText().toString();
                int qu = Integer.parseInt(qun);

                totalnum = qu * 2290;
                insertOrderedcloth();

            }
        });



    }

    private void insertOrderedcloth() {
        datas ty = new datas();
        clothacc uy = new clothacc();

           String colored = ty.setcolor();
           String sized = ty.setSize();
           int totalprice = uy.totalnum;

        Orderdcloth order = new Orderdcloth(colored,sized,totalprice);
        store2.push().setValue(order);

        Toast.makeText(clothacc.this,"Your details are Stored",Toast.LENGTH_SHORT).show();










    }
}

