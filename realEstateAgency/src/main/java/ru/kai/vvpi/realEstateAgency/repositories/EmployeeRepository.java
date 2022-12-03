package ru.kai.vvpi.realEstateAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.vvpi.realEstateAgency.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByPassword(String password);
}
