package ru.kai.vvpi.realEstateAgency.services;

import org.springframework.stereotype.Service;
import ru.kai.vvpi.realEstateAgency.models.Flat;
import ru.kai.vvpi.realEstateAgency.repositories.FlatRepository;

import java.util.List;

@Service
public class FlatService {
    private final FlatRepository flatRepository;

    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public void save(Flat flat){
        flatRepository.save(flat);
    }

    public void delete(Integer id) {
        flatRepository.deleteById(id);
    }

    public List<Flat> getFlatList(){
        return flatRepository.findAll();
    }

    public Flat getFlatById(Integer id){
        return flatRepository.getById(id);
    }

    public List<Flat> getFlatListByAddress(String address){
        return flatRepository.findAllByAddress(address);
    }
}
