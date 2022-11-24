package org.launchcode.demo.controllers;

import org.launchcode.demo.data.EventData;
import org.launchcode.demo.models.Event;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventsController {

//    private static List<Event> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model){
//        model.addAttribute("events", events);
//        return "events/index";
//        events.put("Code code revolution", "Standing desks, games, and coders");
//        events.put("Rihanna meets STL Coders", "Come get under her umbrella");
//        events.put("Another corny event title", "you get it.. we're coding");
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAllEvents());

        return "events/index";
    }
    @GetMapping("create")
    public String displayCreateEventForm(Model model){
//        events.add(new Event(eventName));
        model.addAttribute("title", "Create Event");

        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAllEvents());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEvent(@RequestParam(required = false) int[] eventIds){
       if (eventIds != null) {
           for (int id : eventIds) {
               EventData.remove(id);
           }
       }
        return "redirect:";
    }
}
