package org.formation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/ping")
    public String ping(Model model) {
        model.addAttribute("message", "En ligne");
        return "index"; // Le nom de la vue (page HTML) à afficher
    }

}
