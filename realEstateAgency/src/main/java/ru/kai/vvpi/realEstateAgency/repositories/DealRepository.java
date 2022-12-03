package ru.kai.vvpi.realEstateAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.vvpi.realEstateAgency.models.Deal;

public interface DealRepository extends JpaRepository<Deal, Integer> {
}
