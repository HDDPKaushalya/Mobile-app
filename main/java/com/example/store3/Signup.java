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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    DatabaseReference store2;
    ImageButton facebookIb,googlIb;
    TextView vali1;
    EditText username,pass,address,email;
    Button logb,sigb,googlb,facebookb;
    FirebaseAuth mAuth;
    ProgressBar pogbar;

    FirebaseDatabase store;
    // GoogleSignInClient  client1;


    class user {
        String email;
        String password;
        String address;
        public String getAddress(){
            return address;
        }
        public String getPassword(){
            return  password;
        }
        public String getemail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setAddress(String address){
            this.address = address;
        }


    }

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
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        store = FirebaseDatabase.getInstance();

        googlb = findViewById(R.id.googlb);
        facebookb = findViewById(R.id.facebookb);
        facebookIb = findViewById(R.id.facebookIb);
        googlIb = findViewById(R.id.googlIb);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        logb = findViewById(R.id.logb);
        sigb = findViewById(R.id.sigb);
        vali1 = findViewById(R.id.vali1);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        pogbar = findViewById(R.id.pogbar);


        sigb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pogbar.setVisibility(view.VISIBLE);
                String pass1 = pass.getText().toString();
                String username1 = username.getText().toString();
                String address1 =  address.getText().toString();
                String email1 = email.getText().toString();

                if(TextUtils.isEmpty(pass1)){
                    vali1.setText("Please enter the password");
                    return;
                }
                if(TextUtils.isEmpty(username1)){
                    vali1.setText("Please enter the username");
                    return;
                }
                if(TextUtils.isEmpty(address1)){
                    vali1.setText("Please enter the address");
                    return;

                }
                if(TextUtils.isEmpty(email1)){
                    vali1.setText("Please enter the email");

                }
                mAuth.createUserWithEmailAndPassword(email1, pass1)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pogbar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(Signup.this, "Account create.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }

                        });
                user mn = new user();
                 mn.setEmail(email1);
                 mn.setAddress(address1);
                 mn.setPassword(pass1);

            }

        });
        store2 = FirebaseDatabase.getInstance().getReference().child("User");
        logb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Blog = new Intent(getApplicationContext(), Login.class);
                startActivity(Blog);
            }
        });




    }
    public void insertuser(){
        user hj = new user();
        String email = hj.getemail();
        String address = hj.getAddress();
        String pass = hj.getPassword();

        User user = new User(email,pass,address);
        store2.push().setValue(user);

        Toast.makeText(Signup.this,"stored",Toast.LENGTH_SHORT).show();
    }

}