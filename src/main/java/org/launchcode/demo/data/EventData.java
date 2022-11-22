package org.launchcode.demo.data;

import org.launchcode.demo.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // need place to put events
    private static final Map<Integer, Event> events = new HashMap<>();

    // get all events
    public static Collection<Event> getAllEvents(){
        return events.values();
    }
    // get a single event
    public static Event getByID(int id){
        return events.get(id);
    }
    // add events
    public static void add(Event event) {
        events.put(event.getId(), event);
    }
    // remove an event
    public static void remove( int id){
        events.remove(id);
    }
}
