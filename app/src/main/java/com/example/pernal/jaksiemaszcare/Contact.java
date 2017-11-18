package com.example.pernal.jaksiemaszcare;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.net.URL;

/**
 * Created by pernal on 18.11.17.
 */

public class Contact implements Parcelable {

    private String contactName;
    private String contactNumber;
    private String contactUrl;

    public Contact(String contactName, String contactNumber, String contactUrl) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.contactUrl = contactUrl;
    }

    public Contact(Parcel in){
                 String[] data = new String[3];

                 in.readStringArray(data);
                 this.contactName = data[0];
                 this.contactNumber = data[1];
                 this.contactUrl = data[2];
    }


    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.contactName,
                                            this.contactNumber,
                                            this.contactUrl});
    }

    public static final Creator CREATOR = new Creator() {
        @NonNull
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @NonNull
        @org.jetbrains.annotations.Contract(pure = true)
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
