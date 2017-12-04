package com.example.pernal.jaksiemaszcare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pernal.jaksiemaszcare.interfaces.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-12-03.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    ArrayList<Contact> contactList = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    OnItemClickListener listener;

    public ContactsAdapter(Context context, ArrayList<Contact> contactList, OnItemClickListener onItemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.contactList = contactList;
        this.context = context;
        this.listener = onItemClickListener;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact_view, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        Contact viewContact = contactList.get(position);
        holder.bind(viewContact, listener);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public ArrayList<Contact> getContactList(){
        return contactList;
    }

}
