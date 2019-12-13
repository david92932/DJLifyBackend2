package com.djlify.demo.Models;

import com.djlify.demo.Controllers.SpotifyClient;

import java.util.ArrayList;

public class AttendeeModel {

    private SpotifyClient spotifyClient = new SpotifyClient();
    private EventModel event;

    private void requestSong(SongModel song)
    {

    }

    private void upvoteSong(SongModel song)
    {

    }

    private ArrayList<SongModel> searchSong(String searchAttribute)
    {
        ArrayList<SongModel> results = new ArrayList<>();

        spotifyClient.clientCredential_Sync();
        results = spotifyClient.searchSong(searchAttribute);

        return results;
    }


}
