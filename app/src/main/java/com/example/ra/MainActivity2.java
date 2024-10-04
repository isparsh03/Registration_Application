package com.example.ra;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    EditText e1,e2;
    ProgressBar p1;
    Button b1,b2;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        e1 = (EditText) findViewById(R.id.editTextText3);
        e2 = (EditText) findViewById(R.id.editTextText4);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        p1 = (ProgressBar) findViewById(R.id.progressBar2);
        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button4);
        fa = FirebaseAuth.getInstance();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty())
                {
                    e1.setError("Fill Email");
                    return;
                }
                else
                {
                    if(s2.isEmpty())
                    {
                        e2.setError("Fill Password");
                    }
                    else
                    {
                        p1.setVisibility(View.VISIBLE);
                        fa.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity2.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent k = new Intent(MainActivity2.this,MainActivity.class);
                                    startActivity(k);
                                    finish();
                                }
                                else
                                {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity2.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });

    }
}