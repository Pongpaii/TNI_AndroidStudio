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

public class week6_C extends AppCompatActivity {

    Button myCtoA,myCtob;
    TextView myresult6c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week6_c);

        myCtoA = findViewById(R.id.pgCtoA);
        myCtob=findViewById(R.id.PgCtoB);
        myresult6c=findViewById(R.id.resultC);

        //connect db
        final SharedPreferences sp = this.getSharedPreferences("sharename", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit() ;

        String name6b = sp.getString("my_name","Quandale Dingle");
        int scoreb =sp.getInt("my_score",0);
        myresult6c.setText("Hi "+ name6b +"\nYour Score is " +scoreb);

        myCtob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent =new Intent(getApplicationContext(), week6_B.class);
                startActivity(myIntent);
            }
        });
        myCtoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent =new Intent(getApplicationContext(), week6_A.class);
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