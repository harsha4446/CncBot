package com.example.harsha.cncbot;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button square,triangle,clr, line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new touchControl(this,null));
        square=(Button)findViewById(R.id.btn_square);
        triangle=(Button)findViewById(R.id.btn_triangle);
        line=(Button)findViewById(R.id.btn_line);
        clr=(Button)findViewById(R.id.btn_clear);
        square.setOnClickListener();
    }
}