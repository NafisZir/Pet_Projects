package ru.kai.vvpi.realEstateAgency.services;

import org.springframework.stereotype.Service;
import ru.kai.vvpi.realEstateAgency.models.Owner;
import ru.kai.vvpi.realEstateAgency.repositories.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository customerRepository) {
        this.ownerRepository = customerRepository;
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    public List<Owner> getOwnerList(){
        return ownerRepository.findAll();
    }

    public Integer getOwnerByPhone(String phone){
        return ownerRepository.findByPhone(phone).getId();
    }

    public String getOwnerName(Integer id){
        return ownerRepository.findById(id).orElse(null).getName();
    }
}
