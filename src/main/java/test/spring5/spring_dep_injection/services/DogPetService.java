package test.spring5.spring_dep_injection.services;

public class DogPetService implements PetService{
    @Override
    public String getPetType() {
        return "Dog";
    }
}
