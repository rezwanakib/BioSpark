package com.example.biospark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        button = (Button) findViewById(R.id.buttonid);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if(currentUser == null){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //if it is null then it will shift to register activity wher user can sign or sign up
                    Intent RegisterIntent = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(RegisterIntent);
                }
            });

        }else{
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //this will run when already a user exists
                    Intent mainIntent = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(mainIntent);
                }
            });
        }
    }
}