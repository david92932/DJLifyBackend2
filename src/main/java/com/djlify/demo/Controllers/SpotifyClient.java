package com.djlify.demo.Controllers;

import com.djlify.demo.Models.SongModel;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;

import java.io.IOException;
import java.util.ArrayList;

public class SpotifyClient {



    private static final String clientID = "172db9e2b2df4acda5cc2fb603038ddd";
    private static final String clientSecret = "b5abeb08f53a4aa287c5eff7a3ab69ca";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientID).setClientSecret(clientSecret).build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    public static void clientCredential_Sync()
    {
        try{
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("ACCESS TOKEN: Expires in: " + clientCredentials.getExpiresIn());
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  SearchTracksRequest searchTrackRequest;

    public static ArrayList<SongModel> searchSong(String searchAttribute) //searches for requested attribute, returns list of SongModel objects
    {

        searchTrackRequest = spotifyApi.searchTracks(searchAttribute).build();

        ArrayList<SongModel> searchResults = new ArrayList<>();

        try {

             Paging<Track> trackPaging = searchTrackRequest.execute();
             Track[] items = trackPaging.getItems();

            ArtistSimplified[] artists;

             System.out.println("\n\n\n");

             for (int i = 0; i < 25 && i < items.length; i++)
             {
                 artists = items[i].getArtists();
                 //System.out.println("\n\n\nName: " + items[i].getName() + "\nArtist: " + artists[0].getName() + "\nID: " + items[i].getId() + "\nURI: " + items[i].getUri() + "\nDuration: " + items[i].getDurationMs() + "\nExplicit: " + items[i].getIsExplicit());

                 //System.out.println("\n" + items[i].getPreviewUrl());
                 System.out.println("\n" + items[i].getAlbum().getName());

                 SongModel temp = new SongModel(items[i].getName(), artists[0].getName(), items[i].getId(),items[i].getPreviewUrl(), items[i].getUri(), items[i].getDurationMs(), items[i].getIsExplicit());
                 searchResults.add(temp);
             }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public static void main(String[] args)
    {

        clientCredential_Sync(); //initializeAPI

        ArrayList<SongModel> theList = new ArrayList<>(); //initialize list of songs

        theList = searchSong("John Mayer"); //Search for tracks

        for(int i = 1; i < theList.size(); i++) //Display results in console
        {
            System.out.println("\n\nName: " + theList.get(i).getName() + "\nArtist: " + theList.get(i).getArtist()
                                + "\nID: " + theList.get(i).getID() + "\nPreview: " + theList.get(i).getPreviewURL()
                                + "\nUri: " + theList.get(i).getURI() + "\nDuration(ms): " + theList.get(i).getDuration()
                                + "\nExplicit: " + theList.get(i).isExplicit());
        }
    }
}