package com.example.pernal.jaksiemaszcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainActivityToolbar;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        button = (Button) findViewById(R.id.button);
        intent = new Intent(this,  SecondActivity.class);

        setSupportActionBar(mainActivityToolbar);

        button.setOnClickListener((view) -> startActivity(intent));

    }
}
