package com.example.tni_androidstudio_workshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week5_A extends AppCompatActivity {
    //step1 declare
    Button myOpen5B,myviewadd ,mymapview,mygotoC;

    EditText mynickname , myscore ,myuserheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week5);
        //step2 put Id in variable
        myOpen5B = findViewById(R.id.Open5B);
        myviewadd = findViewById((R.id.viewAdd));
        mymapview = findViewById(R.id.mapview);
        mynickname=findViewById(R.id.nickname);
        myscore=findViewById(R.id.weight);
        mygotoC=findViewById(R.id.OpenC);
       myuserheight=findViewById(R.id.poipheight);

        //step 3 make event
        myOpen5B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
                Intent myintent = new Intent(getApplicationContext(), week5_B.class);
                startActivity(myintent);
            }
        });
        //step 3 make event
        mygotoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
                String nname1 = mynickname.getText().toString();
                int weight1 = Integer.parseInt(myscore.getText().toString());
                int height1= Integer.parseInt(myuserheight.getText().toString());
                Intent myintent = new Intent(getApplicationContext(), week5_C.class);
                myintent.putExtra("weightsend",weight1);
                myintent.putExtra("heightsend",height1);

                startActivity(myintent);
            }
        });


        //step 3 make event
        myviewadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
                String geocode="geo:0,0?q=ป้าย @ก็รัก";
                Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse(geocode ));
                startActivity(myintent);
            }
        });

        //step 3 make event
        mymapview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract latitude and longitude from the URL (you'll need to implement this part)
                double latitude = 35.7040744;  // Replace with extracted latitude
                double longitude = 139.5577317; // Replace with extracted longitude

                //step4 Construct the geocode URI
                String geocode = "google.streetview:cbll=" + latitude + "," + longitude;
                Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse(geocode));
                startActivity(myintent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.userheight), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}