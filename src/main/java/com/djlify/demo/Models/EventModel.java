package com.djlify.demo.Models;

import com.djlify.demo.Controllers.SpotifyClient;

import java.util.ArrayList;

public class EventModel {

    public String eventID, hostingLocation, eventURL, eventName;
    DJModel hostingDJ;
    ArrayList<SongModel> songList = new ArrayList<SongModel>();
    SpotifyClient spotifyClient;

    EventModel()
    {
        this.eventID = null;
        this.eventURL = null;
        this. hostingLocation = null;
        this.hostingDJ = new DJModel();

    }

    public EventModel(String eventName, String eventID, String eventURL, String hostingLocation, DJModel hostingDJ)
    {
        this.eventName = eventName;
        this.eventID = eventID;
        this.eventURL = eventURL;
        this.hostingDJ = hostingDJ;
        this.hostingLocation = hostingLocation;

    }

    public void addSong(SongModel song)
    {
        songList.add(song);
    }

    public void removeSong(SongModel song)
    {
        songList.remove(song);
    }

    public void playSong(SongModel song)
    {
        //TODO: play song functionality integration may need to be removed -- check documentation and time for project
    }

    public void upvoteSong(SongModel song)
    {
        song.upvoteSong();
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }

    public void setHostingDJ(DJModel hostingDJ) {
        this.hostingDJ = hostingDJ;
    }

    public void setHostingLocation(String hostingLocation) {
        this.hostingLocation = hostingLocation;
    }

    public ArrayList<SongModel> getSongList() {
        return songList;
    }

    public DJModel getHostingDJ() {
        return hostingDJ;
    }

    public String getEventID() {
        return eventID;
    }

    public String getEventURL() {
        return eventURL;
    }

    public String getHostingLocation() {
        return hostingLocation;
    }

    public String getEventName() {
        return eventName;
    }
}
