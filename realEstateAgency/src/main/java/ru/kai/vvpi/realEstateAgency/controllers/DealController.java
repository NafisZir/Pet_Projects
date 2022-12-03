package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.vvpi.realEstateAgency.models.Deal;
import ru.kai.vvpi.realEstateAgency.services.*;

@Controller
public class DealController {
    private final CustomerService customerService;
    private final FlatService flatService;
    private final DealService dealService;
    private final OwnerService ownerService;
    private final EmployeeService employeeService;

    public DealController(CustomerService customerService, FlatService flatService, DealService dealService, OwnerService ownerService, EmployeeService employeeService) {
        this.customerService = customerService;
        this.flatService = flatService;
        this.dealService = dealService;
        this.ownerService = ownerService;
        this.employeeService = employeeService;
    }

    @GetMapping("/deal/new")
    public String newDeal(Model model){
        model.addAttribute("customers", customerService.getCustomerList());
        model.addAttribute("flats", flatService.getFlatList());
        model.addAttribute("employee_id", employeeService.getWho());
        return "newDeal";
    }

    @GetMapping("/deal/show")
    public String showDeal(Model model){
        model.addAttribute("deals", dealService.getDealList());
        return "showDeal";
    }

    @GetMapping("/deal-info/{id}")
    public String dealInfo(@PathVariable("id") Integer id, Model model){
        Deal deal = dealService.getDealById(id);
        model.addAttribute("deal", deal);
        model.addAttribute("customer", customerService.getCustomerName(deal.getCustomerId()));
        model.addAttribute("owner", ownerService.getOwnerName(flatService.getFlatById(deal.getFlatId()).getOwnerId()));
        model.addAttribute("flat", flatService.getFlatById(deal.getFlatId()));
        model.addAttribute("employee", employeeService.getEmployeeName(deal.getEmployeeId()));
        return "deal-info";
    }

    @PostMapping("/deal/create")
    public String createDeal(Deal deal){
        deal.setEmployeeId(employeeService.getWho());
        dealService.save(deal);
        return "redirect:/deal/show";
    }

    @PostMapping("/deleteDeal/{id}")
    public String deleteDeal(@PathVariable("id") Integer id){
        dealService.delete(id);
        return "redirect:/deal/show";
    }

    @GetMapping("/requestShow")
    public String requestShow(Model model){
        model.addAttribute("customers", customerService.getCustomerList());
        model.addAttribute("owners", ownerService.getOwnerList());
        return "requestShow";
    }
}
