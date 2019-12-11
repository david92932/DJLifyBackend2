package com.djlify.demo.Controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.ArrayList;

public class SpotifyClient {

    private static final String clientID = "172db9e2b2df4acda5cc2fb603038ddd";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientID).build();

    private static  SearchTracksRequest searchTrackRequest;

    public static ArrayList<Track[]> searchSong(String searchAttribute)
    {

        searchTrackRequest = spotifyApi.searchTracks(searchAttribute).build();
        ArrayList<Track[]> list = new ArrayList<>();

        try {

             Paging<Track> trackPaging = searchTrackRequest.execute();
             Track[] items = trackPaging.getItems();
             list.add(items);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        }

        return list;
    }

}
