package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.vvpi.realEstateAgency.models.Flat;
import ru.kai.vvpi.realEstateAgency.models.Owner;
import ru.kai.vvpi.realEstateAgency.services.FlatService;
import ru.kai.vvpi.realEstateAgency.services.OwnerService;

@Controller
public class OwnerController {
    private final OwnerService ownerService;
    private final FlatService flatService;

    public OwnerController(OwnerService ownerService, FlatService flatService) {
        this.ownerService = ownerService;
        this.flatService = flatService;
    }

    @GetMapping("/signupowner")
    public String owner(){
        return "signUpOwner";
    }

    @PostMapping("/owner/new")
    public String ownerNew(Owner owner, Model model){
        ownerService.save(owner);
        model.addAttribute("owner", ownerService);
        model.addAttribute("phone", owner.getPhone());
        return "newFlat";
    }

    @PostMapping("/flat/new/{owner_id}")
    public String newFlat(@PathVariable("owner_id") Integer id, Flat flat){
        flat.setOwnerId(id);
        flatService.save(flat);
        return "success";
    }
}
