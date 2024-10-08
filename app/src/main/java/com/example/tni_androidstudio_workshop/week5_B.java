package com.example.tni_androidstudio_workshop;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week5_B extends AppCompatActivity {
    Button myOpen5A ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week5_b);

        /*
        //step 3 make event
        myOpen5A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step4
                Intent myintent = new Intent(getApplicationContext(), week5_A.class);
                startActivity(myintent);
            }
        });
*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.userheight), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}