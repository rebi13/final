package com.example.blueblue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sub2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        Button back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//이전 화면으로 이동
            }
        });

        Button soohwa=findViewById(R.id.soohwa);
        soohwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sub2Activity.this,Sub3Activity.class);
                startActivity(intent);
            }
        });

        Button scaling=findViewById(R.id.scaling);
        scaling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sub2Activity.this,Sub4Activity.class);
                startActivity(intent);
            }
        });

        Button pair=findViewById(R.id.pair);
        pair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sub2Activity.this,Sub5Activity.class);
                startActivity(intent);
            }
        });

    }
}