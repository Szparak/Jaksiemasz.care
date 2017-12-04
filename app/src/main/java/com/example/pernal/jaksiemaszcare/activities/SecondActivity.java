package com.example.pernal.jaksiemaszcare.activities;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pernal.jaksiemaszcare.Contact;
import com.example.pernal.jaksiemaszcare.Helper;
import com.example.pernal.jaksiemaszcare.R;
import com.squareup.picasso.Picasso;




public class SecondActivity extends AppCompatActivity {

    private Toolbar secondActivityToolbar;
    private final String TOAST_MESSAGE = "A2 closed";
    private TextView contactTelTextView;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView parallaxImage;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(savedInstanceState==null){
            initUi();
            fillLayout(getContact());
        }

    }

    private void initUi(){
        secondActivityToolbar = findViewById(R.id.my_toolbar);
        contactTelTextView = findViewById(R.id.contact_number);
        collapsingToolbar = findViewById(R.id.collapse_toolbar);
        parallaxImage = findViewById(R.id.bar_image);

        setSupportActionBar(secondActivityToolbar);
        ActionBar secondActivityActionBar = getSupportActionBar();

        if(secondActivityActionBar!=null){
            secondActivityActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("contact" , contact);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        contact = savedInstanceState.getParcelable("contact");
        initUi();
        fillLayout(contact);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private Contact getContact() {
        Bundle data = getIntent().getExtras();
        contact = data.getParcelable("contact");
        return contact;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        Helper.makeAndShowToast(TOAST_MESSAGE, this);
        super.onDestroy();
    }

    public void fillLayout(Contact contact){

        collapsingToolbar.setTitle(contact.getContactName());
        contactTelTextView.setText(contact.getContactNumber());
        Picasso.with(this).load(contact.getContactUrl()).into(parallaxImage);
    }

}
