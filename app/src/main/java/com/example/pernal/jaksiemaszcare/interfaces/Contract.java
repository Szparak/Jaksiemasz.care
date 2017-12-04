package com.example.pernal.jaksiemaszcare.interfaces;


import android.content.Context;
import android.content.Intent;

import com.example.pernal.jaksiemaszcare.Contact;
import com.example.pernal.jaksiemaszcare.ContactsAdapter;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-12-02.
 */

public interface Contract {
    interface View{
        void setAndAttachAdapter(ArrayList<Contact> contactList);
        void startSecondActivity(Intent intent);
    }

    interface Presenter{
        void attachView(Contract.View view);
        void detachView();
        void recyclerItemClick(Context context, Contact contact);
        boolean recyclerItemLongClick(ContactsAdapter adapter, Contact contact);
        void loadData();
        void loadData(ArrayList<Contact> contacts);
    }
}
