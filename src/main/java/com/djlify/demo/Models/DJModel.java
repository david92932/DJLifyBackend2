package com.djlify.demo.Models;

import java.util.ArrayList;

public class DJModel {

    public String fname, lname, ID, pictureURL, biography;

    public ArrayList<EventModel> events = new ArrayList<EventModel>();



    DJModel(){
        this.fname = null;
        this.lname = null;
        this.ID = null;
        this.pictureURL = null;
        this.biography = null;

    }

    DJModel(String fname, String lname, String ID, String pictureURL, String biography)
    {
        this.fname = fname;
        this.lname = lname;
        this.ID = ID;
        this.pictureURL = pictureURL;
        this.biography = biography;
    }

    public void addEvent(EventModel event) {
        this.events.add(event);
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getID() {
        return ID;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public String getBiography() {
        return biography;
    }

    public ArrayList<EventModel> getEvents() {
        return events;
    }

}
