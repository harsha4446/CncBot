package com.example.harsha.cncbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new com.example.harsha.cncbot.touchControl(this,null));
    }

    /**
     * Created by Harsha on 3/6/2017.
     */

    public static class touchControl {
    }
}
