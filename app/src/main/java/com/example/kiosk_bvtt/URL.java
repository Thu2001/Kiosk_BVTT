package com.example.kiosk_bvtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class URL extends AppCompatActivity {
    EditText url;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_url);

        bt1 = findViewById(R.id.bt1);
        url = findViewById(R.id.url);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a="https://"+url.getText().toString();

                Intent intent2 = new Intent(URL.this, MainActivity.class);
                intent2.putExtra("url",a);
                startActivity(intent2);
            }
        });

    }
}