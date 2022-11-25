package org.launchcode.demo.controllers;

import org.launchcode.demo.data.EventData;
import org.launchcode.demo.models.Event;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import javax.validation.Valid;
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
        model.addAttribute("event", new Event());

        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            //model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }
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

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here
        model.addAttribute("title", "Edit Event: " + EventData.getByID(eventId).getName() + " " + EventData.getByID(eventId).getId());
        model.addAttribute("event", EventData.getByID(eventId));
        return "events/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
        Event eventToEdit = EventData.getByID(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }

}
