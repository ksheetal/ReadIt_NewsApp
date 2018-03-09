package com.crypticducs000webhost.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn= (Button)findViewById(R.id.lets_start);
        Button btn1 =(Button)findViewById(R.id.rate_this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,about.class);
                Toast.makeText(Home.this,"Opening...",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                Toast.makeText(Home.this,"Opening...",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
    }
}
