package test.spring5.spring_dep_injection.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CatPetService implements PetService{
    @Override
    public String getPetType() {
        return "Cat";
    }
}
