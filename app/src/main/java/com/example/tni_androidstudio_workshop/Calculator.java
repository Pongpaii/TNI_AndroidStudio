package com.example.tni_androidstudio_workshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {


    EditText num1EditText, num2EditText;
    Button myplus,myminus,mymultiply,mydiv;
    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        num1EditText = findViewById(R.id.num1);
        num2EditText = findViewById(R.id.num2);
        myplus = findViewById(R.id.plus_btn);
        myminus = findViewById(R.id.minus_btn);
        mymultiply = findViewById(R.id.multiply_btn);
        mydiv = findViewById(R.id.div_btn);







        //step3for plus
        myplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num1EditText.getText().toString().equals("")){
                    num1EditText.setError("Please in put number1");
                }
                else if (num2EditText.getText().toString().equals("")){
                    num1EditText.setError("Please in put number2");
                }
                else {

                }

                //step4 for plus
                if(num1EditText.getText().toString().equals("")){
                    num1EditText.setError("please input number");
                } else if (num2EditText.getText().toString().equals("")) {
                    num2EditText.setError("please input number");

                }
                else {
                    int x = Integer.parseInt((num1EditText.getText().toString()));
                    int y = Integer.parseInt((num2EditText.getText().toString()));
                    int z = x +y;
                    Toast.makeText(getApplicationContext(),"Result = "+z,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}