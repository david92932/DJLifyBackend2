package com.djlify.demo.Controllers;

import com.djlify.demo.Models.DJModel;
import com.djlify.demo.Models.EventModel;
import com.djlify.demo.Models.SongModel;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.djlify.demo.Controllers.DJController.allDJs;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})

public class EventController {

    int countingEventID = 0;
    public static ArrayList<SongModel> masterList = new ArrayList<>();
    public static ArrayList<EventModel> allEvents = new ArrayList<>();
    private SpotifyClient spotifyClient = new SpotifyClient();

    public static void createEvent()
    {
        EventModel eventModel;
        eventModel = new EventModel("Wedding","00001e00001m", "DJLify.com/00001e00001m", "Erie PA", DJController.allDJs.get(1));
        allEvents.add(eventModel);
    }

    @GetMapping(path = "Event/getEvent")
    public EventModel getEvent(@RequestParam("ID") String ID) {

        for (EventModel event : allEvents) {
            if (event.getEventID().equals(ID)) {
                return event;
            }
        }

        return null;

    }

    /**
     * Returns all events associated with a DJ
     *
     * @param DJID: string DJ ID
     * @return EventModel ArrayList with all DJ events
     */
    @GetMapping(path = "Event/getDJEvents")
    public ArrayList<EventModel> getDJEvent(@RequestParam("ID") String DJID) {

        ArrayList<EventModel> DJEvents = new ArrayList<>();

        for (EventModel event : allEvents) {

            DJModel tempDJ = event.getHostingDJ();
            String tempDJID = tempDJ.getID();

            if (tempDJID.equals(DJID)) {
                DJEvents.add(event);
            }

        }

        return DJEvents;

    }

    @GetMapping(path = "Event/AddEvent")
    public void addEvent(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("DJ") String DJid) {

        DJModel dj = new DJModel();

        for (DJModel djModel: allDJs)
        {
            if (djModel.getID().equals(DJid))
            {
                dj = djModel;
                break;
            }
        }

        EventModel event = new EventModel(name,countingEventID + "e" + countingEventID + "m", "DJLify.com/" + countingEventID + "e" + countingEventID + "m", location, dj);

        allEvents.add(event);
    }

    @GetMapping(path = "Event/addSong")
    public void addSong(@RequestParam("eventID") String eventID, @RequestParam("songID") String songID) {

        SongModel song = new SongModel();

        for (SongModel songModel: masterList)
        {
            if (songModel.getID().equals(songID))
            {
                song = songModel;
            }
        }

        boolean added = false;
        for(EventModel event: allEvents) {
            if (event.getEventID().equals(eventID)) {

                for (int i = 0; i < event.getSongList().size(); i++)
                {
                    if (event.getSongList().get(i).equals(song))
                    {
                        event.getSongList().get(i).upvoteSong();
                        added = true;
                    }
                }

                if (!added)
                event.addSong(song);

            }
        }
    }

    @GetMapping(path = "Event/findSong")
    public ArrayList<SongModel> findSong(@RequestParam("query") String query){


        spotifyClient.clientCredential_Sync();

        ArrayList<SongModel> results = new ArrayList<>();

        results = spotifyClient.searchSong(query);

        masterList = results;

        return results;

    }

    @GetMapping(path = "Event/removeSong")
    public void removeSong(@RequestParam("eventID") String eventID, @RequestParam("songID") String songID) {

        for(EventModel event: allEvents) {
            if (event.getEventID().equals(eventID)) {
                ArrayList<SongModel> eventSongs = new ArrayList<>();
                eventSongs = event.getSongList();
                for (SongModel song: eventSongs) {
                    if (song.getID().equals(songID)) {
                        event.removeSong(song);
                    }
                }
            }
        }
    }

    @GetMapping(path = "Event/upvoteSong")
    public void upvoteSong(@RequestParam("eventID") String eventID, @RequestParam("songID") String songID) {

        for(EventModel event: allEvents) {
            if (event.getEventID().equals(eventID)) {
                ArrayList<SongModel> eventSongs = new ArrayList<>();
                eventSongs = event.getSongList();
                for (SongModel song: eventSongs) {
                    if (song.getID().equals(songID)) {
                        event.upvoteSong(song);
                    }
                }
            }
        }
    }
}




