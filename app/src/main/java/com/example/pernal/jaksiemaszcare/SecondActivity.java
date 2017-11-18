package com.example.pernal.jaksiemaszcare;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;


public class SecondActivity extends AppCompatActivity {

    private Toolbar secondActivityToolbar;
    private final String TOAST_MESSAGE = "A2 closed";
    private TextView contactTelTextView;
    Contact contact;
    ImageView contactImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondActivityToolbar = findViewById(R.id.second_toolbar);
        contactTelTextView = findViewById(R.id.contact_tel);
        contactImage = findViewById(R.id.contact_image);

        setSupportActionBar(secondActivityToolbar);
        ActionBar secondActivityActionBar = getSupportActionBar();

        contact = getContact();
        secondActivityActionBar.setTitle(contact.getContactName());

        fillLayout(contact);

        if(secondActivityActionBar!=null){
            secondActivityActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private Contact getContact() {
        Bundle data = getIntent().getExtras();
        contact = data.getParcelable("contact");
        return contact;
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

    public void fillLayout(Contact contact){
        contactTelTextView.setText(contact.getContactNumber());
        Picasso.with(this).load(contact.getContactUrl()).into(contactImage);

    }

}
