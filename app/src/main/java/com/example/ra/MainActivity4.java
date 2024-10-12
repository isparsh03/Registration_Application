package com.example.ra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2,b3;
    FirebaseDatabase fd;
    DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        e1 = (EditText) findViewById(R.id.editTextText5);
        e2 = (EditText) findViewById(R.id.editTextText6);
        e3 = (EditText) findViewById(R.id.editTextText7);
        b1 = (Button) findViewById(R.id.button6);
        b2 = (Button) findViewById(R.id.button7);
        fd = FirebaseDatabase.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(n);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = fd.getReference();
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                Users users = new Users(s1,s2,s3);
                db.child(s3).setValue(users);
                Toast.makeText(MainActivity4.this, "Respose Recorded", Toast.LENGTH_SHORT).show();

            }
        });

    }
}