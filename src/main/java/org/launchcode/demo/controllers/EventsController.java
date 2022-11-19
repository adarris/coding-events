package org.launchcode.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventsController {

    private static HashMap<String, String> events = new HashMap<>();
    @GetMapping
    public String displayEvents(Model model){
//        model.addAttribute("events", events);
//        return "events/index";
        events.put("Code code revolution", "Standing desks, games, and coders");
        events.put("Rihanna meets STL Coders", "Come get under her umbrella");
        events.put("Another corny event title", "you get it.. we're coding");

        model.addAttribute("events", events);

        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEvent(){
        return "events/create";
    }

//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName){
//        events.put(eventName);
//
//        return "redirect:";
//    }
}
