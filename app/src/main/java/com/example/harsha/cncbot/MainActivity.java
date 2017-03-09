package com.example.harsha.cncbot;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        square.setOnClickListener(this);
        triangle.setOnClickListener(this);
        line.setOnClickListener(this);
        clr.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_square:
                touchControl.btn=2;
                break;
            case R.id.btn_triangle:
                touchControl.btn=3;
                break;
            case R.id.btn_line:
                touchControl.btn=1;
                break;
            case R.id.btn_clear:
                break;
        }

    }
}