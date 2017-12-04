package com.example.pernal.jaksiemaszcare;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pernal.jaksiemaszcare.interfaces.OnItemClickListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Jakub on 2017-12-03.
 */

public class ContactsViewHolder extends RecyclerView.ViewHolder {

    TextView contactName;
    TextView contactTelNumber;
    ImageView contactImage;


    public ContactsViewHolder(View itemView) {
        super(itemView);
        contactName = itemView.findViewById(R.id.c_name);
        contactTelNumber = itemView.findViewById(R.id.c_number);
        contactImage = itemView.findViewById(R.id.contact_image);
    }

    public void bind(final Contact contact, final OnItemClickListener listener) {

        contactName.setText(contact.getContactName());
        contactTelNumber.setText(contact.getContactNumber());
        Picasso.with(itemView.getContext()).load(contact.getContactUrl()).into(contactImage);

        itemView.setOnClickListener(v -> listener.onItemClick(contact));
        itemView.setOnLongClickListener(view -> {
            listener.onItemLongClick(contact);
            return true;
        });

    }

}
