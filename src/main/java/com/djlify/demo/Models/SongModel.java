package com.djlify.demo.Models;
import java.lang.String;
import java.util.Date;

public class SongModel {

    String name, ID, previewURL, artist, URI;
    int upvotes, duration;
    boolean explicit, isAdded, isRequested;

    public SongModel()
    {
        this.name = null;
        this.artist = null;
        this.ID = null;
        this.previewURL = null;
        this.duration = 0;
        this.upvotes = 0;
        this.explicit = false;
        this.isAdded = false;
        this.isRequested = false;
    }

    public SongModel(String name, String artist, String ID, String previewURL, String URI, int duration, boolean explicit)
    {
        this.name = name;
        this.artist = artist;
        this.ID = ID;
        this.previewURL = previewURL;
        this.URI = URI;
        this.duration = duration;
        this.upvotes = 0;
        this.explicit = explicit;
        this.isAdded = false;
        this.isRequested = false;
    }

    public void setRequested()
    {
        this.isRequested = true;
    }

    public void setAdded()
    {
        this.isAdded = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public String getArtist() {
        return artist;
    }

    public String getID() {
        return ID;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public int getDuration() {
        return duration;
    }

    public String getURI() {
        return URI;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public boolean isExplicit() { return explicit; }

    public void upvoteSong() {
        this.upvotes++;
    }
}
