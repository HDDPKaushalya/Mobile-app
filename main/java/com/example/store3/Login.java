package com.example.store3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText username,pass;
    Button logb,sigb,googlb,facebookb;
    TextView vali1;
    ImageButton facebookIb,googlIb;
    ProgressBar pogbar;

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent vb = new Intent(getApplicationContext(), HomePage.class);
            startActivity(vb);
            finish();

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        logb = findViewById(R.id.logb);
        sigb = findViewById(R.id.sigb);
        vali1 = findViewById(R.id.vali1);
        //googlb = findViewById(R.id.googlb);
        // facebookb = findViewById(R.id.facebookb);
        // facebookIb = findViewById(R.id.facebookIb);
        //googlIb = findViewById(R.id.googlIb);
        pogbar = findViewById(R.id.pogbar);
        mAuth = FirebaseAuth.getInstance();

        logb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pogbar.setVisibility(View.VISIBLE);
                String pass1 = pass.getText().toString();
                String username1 = username.getText().toString();

                if(TextUtils.isEmpty(pass1)){
                    vali1.setText("Please enter the Password");
                }
                if (TextUtils.isEmpty(username1)) {
                    vali1.setText("please enter the username");

                }
                mAuth.signInWithEmailAndPassword(username1, pass1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pogbar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Login sucessfull",Toast.LENGTH_SHORT).show();
                                    Intent vb = new Intent(getApplicationContext(), HomePage.class);
                                    startActivity(vb);
                                    finish();

                                } else {

                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

        sigb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Bsign = new Intent(getApplicationContext(),Signup.class);
                startActivity(Bsign);
            }
        });

    }
}