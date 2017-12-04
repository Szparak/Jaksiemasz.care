package com.example.pernal.jaksiemaszcare.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.pernal.jaksiemaszcare.Contact;
import com.example.pernal.jaksiemaszcare.ContactsAdapter;
import com.example.pernal.jaksiemaszcare.R;
import com.example.pernal.jaksiemaszcare.implementations.PresenterImpl;
import com.example.pernal.jaksiemaszcare.implementations.RepositoryImpl;
import com.example.pernal.jaksiemaszcare.interfaces.Contract;
import com.example.pernal.jaksiemaszcare.interfaces.OnItemClickListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Contract.View, OnItemClickListener {

    private Toolbar mainActivityToolbar;
    private Contract.Presenter presenter = new PresenterImpl(RepositoryImpl.getInstance());
    private RecyclerView contactRecyclerView;
    private ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("tutaj");

        initUi();
        initPresenter();

//        if(savedInstanceState!=null)
//            presenter.loadData(savedInstanceState.getParcelableArrayList("contacts"));
//        else
        presenter.loadData();
    }

    private void initUi(){
        mainActivityToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainActivityToolbar);

        contactRecyclerView = findViewById(R.id.contacts_recycler_view);
        contactRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contactRecyclerView.setLayoutManager(linearLayoutManager);

    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        System.out.println(outState.size());
//        outState.putParcelableArrayList("contacts" , contactsAdapter.getContactList());
//        System.out.println(outState.size());
//        super.onSaveInstanceState(outState);
//    }


//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        System.out.println("On Restore");
//        presenter.loadData(savedInstanceState.getParcelableArrayList("contacts"));
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    private void initPresenter() {
        presenter.attachView(this);
    }

    @Override
    public void setAndAttachAdapter(ArrayList<Contact> contactList) {
        contactsAdapter = new ContactsAdapter(this, contactList, this);
        contactRecyclerView.setAdapter(contactsAdapter);
    }

    @Override
    public void startSecondActivity(Intent intent) {
        startActivity(intent);
    }


    @Override
    public void onItemClick(Contact contact) {
        presenter.recyclerItemClick(this, contact);
    }

    @Override
    public void onItemLongClick(Contact contact) {
        presenter.recyclerItemLongClick(contactsAdapter, contact);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
