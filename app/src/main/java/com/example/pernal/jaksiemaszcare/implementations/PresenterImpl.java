package com.example.pernal.jaksiemaszcare.implementations;

import android.content.Context;
import android.content.Intent;

import com.example.pernal.jaksiemaszcare.Contact;
import com.example.pernal.jaksiemaszcare.ContactsAdapter;
import com.example.pernal.jaksiemaszcare.activities.SecondActivity;
import com.example.pernal.jaksiemaszcare.interfaces.Contract;
import com.example.pernal.jaksiemaszcare.interfaces.Repository;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-12-02.
 */

public class PresenterImpl implements Contract.Presenter {

    @Nullable
    private Contract.View view;
    private Repository repository;

    public PresenterImpl(Repository repository) {
        this.repository = repository;
    }


    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void recyclerItemClick(Context context, Contact contact) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("contact", contact);

        view.startSecondActivity(intent);
    }

    @Override
    public boolean recyclerItemLongClick(ContactsAdapter adapter, Contact contact) {
        adapter.getContactList().remove(contact);
        adapter.notifyDataSetChanged();

        return true;
    }

    @Override
    public void loadData() {
        view.setAndAttachAdapter(repository.loadContacts());
    }

    @Override
    public void loadData(ArrayList<Contact> contacts) {
        view.setAndAttachAdapter(contacts);
    }

}
