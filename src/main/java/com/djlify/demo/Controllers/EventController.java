package com.djlify.demo.Controllers;

import com.djlify.demo.Models.DJModel;
import com.djlify.demo.Models.EventModel;
import com.djlify.demo.Models.SongModel;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})

public class EventController {

    public static ArrayList<EventModel> allEvents = new ArrayList<EventModel>();
    private SpotifyClient spotifyClient = new SpotifyClient();

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

    @RequestMapping(path = "Event/AddEvent")
    public void addEvent(@RequestBody EventModel event) {
        allEvents.add(event);
    }

    @GetMapping(path = "Event/addSong")
    public void addSong(@RequestParam("eventID") String eventID, @RequestParam("songID") String songID) {

        /*SongModel song = this.spotifyClient.findSongByID(songID);

        for(EventModel event: allEvents) {
            if (event.getEventID().equals(eventID)) {
                event.addSong(song);
            }
        }*/
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




