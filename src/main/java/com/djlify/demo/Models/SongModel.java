package com.djlify.demo.Models;
import java.lang.String;
import java.util.Date;

public class SongModel {

    String name, ID, APIURL, artist;
    int upvotes, duration;
    boolean explicit;

    public SongModel()
    {
        this.name = null;
        this.artist = null;
        this.ID = null;
        this.APIURL = null;
        this.duration = 0;
        this.upvotes = 0;
        this.explicit = false;
    }

    public SongModel(String name, String artist, String ID, String APIURL, int duration, boolean explicit)
    {
        this.name = name;
        this.artist = artist;
        this.ID = ID;
        this.APIURL = APIURL;
        this.duration = duration;
        this.upvotes = 0;
        this.explicit = explicit;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getID() {
        return ID;
    }

    public String getAPIURL() {
        return APIURL;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isExplicit() { return explicit; }

    public void upvoteSong() {
        this.upvotes++;
    }
}
