package ru.kai.vvpi.realEstateAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.vvpi.realEstateAgency.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
