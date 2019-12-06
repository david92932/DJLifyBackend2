package com.djlify.demo.Models;
import java.lang.String;
import java.util.Date;

public class SongModel {

    String name, ID, APIURL, artist;
    Date duration;

    SongModel()
    {
        this.name = null;
        this.artist = null;
        this.ID = null;
        this.APIURL = null;
        this.duration = null;
    }

    SongModel(String name, String artist, String ID, String APIURL, Date duration)
    {
        this.name = name;
        this.artist = artist;
        this.ID = ID;
        this.APIURL = APIURL;
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAPIURL(String APIURL) {
        this.APIURL = APIURL;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
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

    public Date getDuration() {
        return duration;
    }
}
