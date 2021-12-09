package test.spring5.spring_dep_injection.services;

import org.springframework.stereotype.Service;

@Service
public class DogPetService implements PetService{
    @Override
    public String getPetType() {
        return "Dog";
    }
}
