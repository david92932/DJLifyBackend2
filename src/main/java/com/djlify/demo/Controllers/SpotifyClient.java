package com.djlify.demo.Controllers;

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

    public static ArrayList<Track[]> searchSong(String searchAttribute)
    {

        searchTrackRequest = spotifyApi.searchTracks(searchAttribute).build();


        //-----------------------
        ArrayList<Track[]> list = new ArrayList<>();

        try {

             Paging<Track> trackPaging = searchTrackRequest.execute();
             Track[] items = trackPaging.getItems();

            ArtistSimplified[] artists;

             System.out.println("\n\n\n");

             for (int i = 0; i < 10 && i < items.length; i++)
             {
                 artists = items[i].getArtists();
                 System.out.println("\nName: " + items[i].getName() + " -- Artist: " + artists[0].getName());
             }

             list.add(items);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args)
    {

        clientCredential_Sync();

        ArrayList<Track[]> theList = new ArrayList<>();
        Track track;

        theList = searchSong("The Search For Everything");



        for (int i = 0; i < theList.size(); i++) {
            System.out.println("\n\n\n");
            System.out.printf("SONG: " + theList.get(i).toString());
        }


    }

}

