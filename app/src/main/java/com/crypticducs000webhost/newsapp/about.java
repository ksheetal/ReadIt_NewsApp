package com.crypticducs000webhost.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button calling = (Button)findViewById(R.id.call);
        Button send_email = (Button)findViewById(R.id.send_mail);


        //sending Email
        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(about.this,"Coming soon...",Toast.LENGTH_SHORT).show();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto","sheetalneo@gmail.com",null));
                // subject of intent
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"ReadIt_NewsApp_Error");
                // Email body
               // emailIntent.putExtra(In)
               // emailIntent.putExtra(Intent.EXTRA_STREAM,attachedFileUri);
                if(emailIntent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(Intent.createChooser(emailIntent,"Choose your mail application"));
                }
                else
                {
                    Toast.makeText(about.this,"Error from else part",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // calling option
        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9540217306"));
                startActivity(intent);
            }
        });
    }
}
