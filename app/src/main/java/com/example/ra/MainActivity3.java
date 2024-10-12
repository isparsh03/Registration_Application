package com.example.ra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class MainActivity3 extends AppCompatActivity {
    Button b1,b2;
    FirebaseAuth fa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        b1 = (Button) findViewById(R.id.button5);
        fa = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fa.signOut();
                Intent m = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(m);
                finish();
                Toast.makeText(MainActivity3.this, "Thanks For Your Response", Toast.LENGTH_SHORT).show();

            }
        });


    }
}