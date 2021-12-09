package test.spring5.spring_dep_injection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import test.spring5.spring_dep_injection.services.PetService;

@Controller
public class PetController {


    private final PetService petService;

    public PetController(@Qualifier("dogPetService")PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
