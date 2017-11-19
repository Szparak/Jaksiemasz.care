package com.example.pernal.jaksiemaszcare;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;




public class SecondActivity extends AppCompatActivity {

    private Toolbar secondActivityToolbar;
    private final String TOAST_MESSAGE = "A2 closed";
    private TextView contactTelTextView;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView parallaxImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondActivityToolbar = findViewById(R.id.my_toolbar);
        contactTelTextView = findViewById(R.id.contact_number);
        collapsingToolbar = findViewById(R.id.collapse_toolbar);
        parallaxImage = findViewById(R.id.bar_image);

        setSupportActionBar(secondActivityToolbar);
        ActionBar secondActivityActionBar = getSupportActionBar();

        fillLayout();

        if(secondActivityActionBar!=null){
            secondActivityActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private Contact getContact() {
        Bundle data = getIntent().getExtras();
        return data.getParcelable("contact");
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

    public void fillLayout(){
        Contact contact = getContact();

        collapsingToolbar.setTitle(contact.getContactName());
        contactTelTextView.setText(contact.getContactNumber());
        Picasso.with(this).load(contact.getContactUrl()).into(parallaxImage);
    }

}
