package com.example.store3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomePage extends AppCompatActivity {
ImageView D1,D2,g1,g1c1,g1c2,cart;

TextureView uname;

DatabaseReference store2;
FirebaseAuth auth;
FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
       // D1 = findViewById(R.id.D1);
      //  v1 = findViewById(R.id.v1);
        g1 = findViewById(R.id.g1c1);
        g1c1 = findViewById(R.id.g1c1);
        g1c2 = findViewById(R.id.g1c2);
        cart = findViewById(R.id.cart);
        uname = findViewById(R.id.uname);

        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent di = new Intent(getApplicationContext(), Discounts.class);
                startActivity(di);
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent di = new Intent(getApplicationContext(), Discounts.class);
                startActivity(di);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(getApplicationContext(),cart.class);
                startActivity(log);
            }
        });
        store2 = FirebaseDatabase.getInstance().getReference().child("Usernames");

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if(user == null){
            Intent io = new Intent(getApplicationContext(), Login.class);
            startActivity(io);
            finish();
        }
        else{
            //textview
           // FirebaseAuth.getInstance().signOut();
            /* Intent io = new Intent(getApplicationContext(), Login.class);
            startActivity(io);
            finish();

             */

        }
    }
}