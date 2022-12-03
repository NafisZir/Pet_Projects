package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.vvpi.realEstateAgency.models.Customer;
import ru.kai.vvpi.realEstateAgency.services.CustomerService;

@Controller
public class BuyController {
    private final CustomerService customerService;

    public BuyController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/signupcustomer")
    public String getSignUpCustomer(){
        return "signUpCustomer";
    }

    @PostMapping("/customer/new")
    public String postSignUpCustomer(Customer customer){
        customerService.save(customer);
        return "success";
    }
}
