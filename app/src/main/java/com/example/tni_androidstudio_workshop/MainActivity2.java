package com.example.tni_androidstudio_workshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    //step1 declare all variable
    TextView myshowtext;
    EditText mytextinput;
    Button mysendbtn;
    EditText mytextinput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        //step2 connect em to variable
        myshowtext= findViewById(R.id.showtext);
        mytextinput=findViewById(R.id.textinput);
        mysendbtn=findViewById(R.id.sendbtn);
        mytextinput2=findViewById(R.id.textinput2);

        //step3 create function
        mysendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step get and show
                String fullName = mytextinput.getText().toString();  //create var name fullname and get from userinput
                String IGN = mytextinput2.getText().toString();
                myshowtext.setText("Hi "+fullName+"\n IGN : " +IGN+" Have fun!");
            }




        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.minus_btn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




    }
}