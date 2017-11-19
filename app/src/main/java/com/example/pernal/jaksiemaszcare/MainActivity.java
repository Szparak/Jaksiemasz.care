package com.example.pernal.jaksiemaszcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Toolbar mainActivityToolbar;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityToolbar = findViewById(R.id.main_toolbar);
        button = findViewById(R.id.button);
        intent = new Intent(this,  SecondActivity.class);

        setSupportActionBar(mainActivityToolbar);

        button.setOnClickListener((view) -> {

            Contact contactToLoad = new Contact("Jakub Pernal", "668529723",
                                                "https://i.ytimg.com/vi/3bqS5L86Jjc/maxresdefault.jpg");

            intent.putExtra("contact", contactToLoad);
            startActivity(intent);

        });

    }
}
