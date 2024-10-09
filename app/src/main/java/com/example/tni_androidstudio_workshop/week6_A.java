package com.example.tni_androidstudio_workshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week6_A extends AppCompatActivity {
//step1
    Button myAtob,myAtoC,mysave6a;
    EditText myname6a,myscore6a;
    Spinner mysp6as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week6);
        //step2
        myAtob = findViewById(R.id.pgAtoB);
        myAtoC = findViewById(R.id.PgAtoC);
        mysave6a=findViewById(R.id.save6a);
        myname6a=findViewById(R.id.nickname6a);
        myscore6a=findViewById(R.id.score6a);
        mysp6as=findViewById(R.id.mysp6a);
        //connect db
        final SharedPreferences sp = this.getSharedPreferences("sharename", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit() ;


        mysave6a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = myname6a.getText().toString();
                int score1 = Integer.parseInt( myscore6a.getText().toString());
                String sp1= mysp6as.getSelectedItem().toString();
                editor.putString( "my_name" ,name1);
                editor.putInt("my_score" ,score1);
                editor.putString("my_sp",sp1);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Save Complete",Toast.LENGTH_SHORT).show();
            }
        });

        //step3
        myAtob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
                Intent myIntent = new Intent(getApplicationContext(),week6_B.class);
                startActivity(myIntent);
            }
        });

        myAtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
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