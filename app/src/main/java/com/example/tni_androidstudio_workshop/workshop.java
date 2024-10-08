package com.example.tni_androidstudio_workshop;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class workshop extends AppCompatActivity {

    Spinner spinner1, spinner2;
    EditText  mygetName;
   TextView myshowtext;
   Button mysubmitbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workshop);
        myshowtext=findViewById(R.id.showtext);
        mygetName=findViewById(R.id.getname);
        mysubmitbtn =findViewById(R.id.submitbtn);
        spinner1 = findViewById(R.id.sl1);
        spinner2 = findViewById(R.id.sl2);
        String[] options1 = {"Lala", "Kai", "Rough"};
        String[] options2 = {"Mingming", "Chowon", "Haru"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        mysubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=mygetName.getText().toString();
                String selectedSpinner1 = spinner1.getSelectedItem().toString();
                String selectedSpinner2 = spinner2.getSelectedItem().toString();


                myshowtext.setText("Hello " + Name + "!\nYou selected: " + selectedSpinner1 + " and " + selectedSpinner2);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.minus_btn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}