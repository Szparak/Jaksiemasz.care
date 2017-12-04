package com.example.pernal.jaksiemaszcare.implementations;

import com.example.pernal.jaksiemaszcare.Contact;
import com.example.pernal.jaksiemaszcare.interfaces.Repository;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-12-02.
 */

public class RepositoryImpl implements Repository {

    public static Repository getInstance(){
        return new RepositoryImpl();
    }

    @Override
    public ArrayList<Contact> loadContacts() {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("Jakub Pernal", "668529723",
                "https://cdn.vox-cdn.com/thumbor/6nr9VzzhuXi1Sam2egh9Fbpcylg=/54x0:885x554/920x613/filters:focal(54x0:885x554):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/42056982/league_of_legends.0.jpg"));
        contactList.add(new Contact("Kasia Kilar" , "999888999",
                "https://riot-web-static.s3.amazonaws.com/images/news/Champ_Splashes/Rengar_Splash.jpg"));
        contactList.add(new Contact("Kamil Serafin" , "998887785",
                "http://vignette2.wikia.nocookie.net/leagueoflegends/images/d/d6/Braum_DragonslayerSkin.jpg/revision/latest?cb=20160518161848"));
        contactList.add(new Contact("Konrad Wilusz" , "999000988",
                "https://www.lol-smurfs.com/wordpress/lol-smurfs/wp-content/uploads/2017/01/Shaco_0.jpg"));
        contactList.add(new Contact("Szymek Faryj" , "888117373",
                "https://d1yauzohz1f7jv.cloudfront.net/production/wp-content/uploads/2017/04/09014024/Lol_newcharacters.jpg"));
        contactList.add(new Contact("Zygmunt Obrzut" , "909998900",
                "https://dotesports-cdn-prod-tqgiyve.stackpathdns.com/thumbor/XLI1XB8YXaonEIhygp9yvmahiRw=/1200x0/filters:no_upscale()/https://dotesports-cdn-prod-tqgiyve.stackpathdns.com/article/646eebe7-29e2-492a-b677-6ce4b33f1990.jpg"));
        contactList.add(new Contact("Bajzel Piotrowski" , "998778665",
                "https://d1jkho2idshhnx.cloudfront.net/blog/wp-content/uploads/2016/04/Malphite_OriginalSkin-1024x604.jpg"));
        contactList.add(new Contact("Janusz Polak" , "998116353",
                "http://memy.pl/show/big/uploads/Post/134155/14908860394757.jpg"));
        contactList.add(new Contact("Grażyna Polak" , "999887889",
                "http://memy.pl/show/big/uploads/Post/114173/14835549129335.jpg"));
        contactList.add(new Contact("Sebastian Polak" , "776777887",
                "https://d-pt.ppstatic.pl/k/r/1/7d/45/518e4f7fa51eb_p.jpg?1400722791"));

        return contactList;
    }
}
