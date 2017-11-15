package com.example.pernal.jaksiemaszcare;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Toolbar secondActivityToolbar;
    private final String TOAST_MESSAGE = "A2 closed";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondActivityToolbar = (Toolbar) findViewById(R.id.second_toolbar);
        setSupportActionBar(secondActivityToolbar);

        ActionBar secondActivityActionBar = getSupportActionBar();

        if(secondActivityActionBar!=null){
            secondActivityActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        Helper.makeAndShowToast(TOAST_MESSAGE, this);
        super.onDestroy();
    }
}
