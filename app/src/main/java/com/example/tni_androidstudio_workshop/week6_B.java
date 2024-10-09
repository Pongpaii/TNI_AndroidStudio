package com.example.tni_androidstudio_workshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.stream.Stream;

public class week6_B extends AppCompatActivity {
    Button myBtoA, myBtoC;
    TextView myresultB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week6_b);
        myBtoA = findViewById(R.id.PgBtoA);
        myBtoC = findViewById(R.id.PgBtoC);
        myresultB = findViewById(R.id.result);
        //connect db
        final SharedPreferences sp = this.getSharedPreferences("sharename", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();


        String name6b = sp.getString("my_name", "none");
        int scoreb = sp.getInt("my_score", 0);
        String sp6b = sp.getString("my_sp", "no");

        if (sp6b.equals("yes")) {
            scoreb += 5;
        } else {
            scoreb = sp.getInt("my_score", 0);
        }

        String G = "F";
        if (scoreb >= 80) {
            G = "A";
        } else if (scoreb >= 70) {
            G = "B";
        } else if (scoreb >= 60) {
            G = "C";
        } else if (scoreb >= 50) {
            G = "D";
        }else{G="F";}

            myresultB.setText("Hi " + name6b + "\nYour Score is " + scoreb + "\nGRADE : " + G);

            myBtoA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(getApplicationContext(), week6_A.class);
                    startActivity(myIntent);
                }
            });


            myBtoC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(getApplicationContext(), week6_C.class);
                    startActivity(myIntent);
                }
            });


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
