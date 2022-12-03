package ru.kai.vvpi.realEstateAgency.services;

import org.springframework.stereotype.Service;
import ru.kai.vvpi.realEstateAgency.models.Customer;
import ru.kai.vvpi.realEstateAgency.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getCustomerList(){
        return customerRepository.findAll();
    }

    public String getCustomerName(Integer id){
        return customerRepository.findById(id).orElse(null).getName();
    }
}
