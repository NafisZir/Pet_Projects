package ru.kai.vvpi.realEstateAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.vvpi.realEstateAgency.models.Flat;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Integer> {
    List<Flat> findAllByAddress(String address);
}
