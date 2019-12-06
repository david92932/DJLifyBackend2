package com.djlify.demo.Models;

import java.util.ArrayList;

public class DJModel {

    public String name;
    public String biography;

    public ArrayList<EventModel> events = new ArrayList<EventModel>();

    public void addEvent(EventModel event) {
        this.events.add(event);
    }

}
