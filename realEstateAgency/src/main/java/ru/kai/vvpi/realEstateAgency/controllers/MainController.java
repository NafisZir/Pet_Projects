package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kai.vvpi.realEstateAgency.services.FlatService;

@Controller
public class MainController {
    private final FlatService flatService;

    public MainController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("flats", flatService.getFlatList());
        return "main";
    }
}
