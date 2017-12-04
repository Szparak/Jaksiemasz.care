package com.example.pernal.jaksiemaszcare.interfaces;

import android.content.Context;

import com.example.pernal.jaksiemaszcare.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub on 2017-12-02.
 */

public interface Repository {
    ArrayList<Contact> loadContacts();
}
