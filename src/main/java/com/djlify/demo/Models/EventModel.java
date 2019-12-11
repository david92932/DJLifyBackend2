package com.djlify.demo.Models;

import java.util.ArrayList;

public class EventModel {

    public String eventID, hostingLocation, eventURL;
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

    EventModel(String eventID, String eventURL, String hostingLocation, DJModel hostingDJ)
    {
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
        //TODO: complete playSong
    }

    public void upvoteSong(SongModel song)
    {
        song.upvoteSong();
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
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
}
