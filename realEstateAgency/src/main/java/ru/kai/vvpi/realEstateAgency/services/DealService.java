package ru.kai.vvpi.realEstateAgency.services;

import org.springframework.stereotype.Service;
import ru.kai.vvpi.realEstateAgency.models.Deal;
import ru.kai.vvpi.realEstateAgency.repositories.DealRepository;

import java.util.List;

@Service
public class DealService {
    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public void save(Deal deal){
        dealRepository.save(deal);
    }

    public void delete(Integer id){
        dealRepository.deleteById(id);
    }

    public List<Deal> getDealList(){
        return dealRepository.findAll();
    }

    public Deal getDealById(Integer id){
        return dealRepository.findById(id).orElse(null);
    }
}
