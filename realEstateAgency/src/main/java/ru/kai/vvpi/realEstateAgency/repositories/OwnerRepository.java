package ru.kai.vvpi.realEstateAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.vvpi.realEstateAgency.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findByPhone(String phone);
}
