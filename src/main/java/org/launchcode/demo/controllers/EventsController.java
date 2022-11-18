package org.launchcode.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventsController {

    public String handlerMethod(Model model){
        List events = new ArrayList();
        events.add("Code Till Dawn");
        events.add("Can't Stop Coding");
        events.add("Resume Support for new developers");
        model.addAttribute("events", events);
        return "events/index";
    }
}
