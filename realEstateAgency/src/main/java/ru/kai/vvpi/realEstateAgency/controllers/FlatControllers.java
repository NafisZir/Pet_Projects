package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.vvpi.realEstateAgency.models.Flat;
import ru.kai.vvpi.realEstateAgency.services.EmployeeService;
import ru.kai.vvpi.realEstateAgency.services.FlatService;

@Controller
public class FlatControllers {
    private final FlatService flatService;
    private final EmployeeService employeeService;

    public FlatControllers(FlatService flatService, EmployeeService employeeService) {
        this.flatService = flatService;
        this.employeeService = employeeService;
    }

    @GetMapping("/flat-info/{id}")
    public String flatInfo(@PathVariable("id") Integer id, Model model){
        model.addAttribute("flat", flatService.getFlatById(id));
        return "flat-info";
    }

    @PostMapping("/deleteFlat/{id}")
    public String deleteFlat(@PathVariable("id") Integer id){
        flatService.delete(id);
        return "deleteFlat";
    }

    @GetMapping("/flat/edit/{id}")
    public String editFlat(@PathVariable("id") Integer id, Model model){
        model.addAttribute("flat",flatService.getFlatById(id));
        return "edit-flat";
    }

    @PostMapping("/editFlat/{id}")
    public String editFlatPost(@PathVariable("id") Integer id, Flat flat){
        Flat oldFlat = flatService.getFlatById(id);
        flat.setId(id);
        flat.setOwnerId(oldFlat.getOwnerId());
        flatService.save(flat);
        return "redirect:/employee";
    }

    @GetMapping("/flat/find")
    public String searchFlat(String address, Model model){
        model.addAttribute("flats", flatService.getFlatListByAddress(address));
        return "main";
    }
}
