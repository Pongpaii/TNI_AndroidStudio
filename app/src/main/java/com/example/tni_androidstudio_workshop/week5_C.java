package com.example.tni_androidstudio_workshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week5_C extends AppCompatActivity {
TextView myresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week5_c);
        myresult =findViewById(R.id.result);

        //step3 gettext step4 show text
        Intent intent2 = getIntent();
        float weightget=intent2.getIntExtra("weightsend",0);
        float heightget=intent2.getIntExtra("heightsend",0);
        String nnameCpage=intent2.getStringExtra("mynickname");
        float hieghtinM =heightget/100;
        float Bmi=weightget/((heightget/100)*(heightget/100));

        myresult.setText("what is up m3mb3r "+nnameCpage+" Your Weight is " +weightget+" Your height is " + heightget +" Your BMI is "+Bmi);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.userheight), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}