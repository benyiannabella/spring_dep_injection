package test.spring5.spring_dep_injection.services;

public class CatPetService implements PetService{
    @Override
    public String getPetType() {
        return "Cat";
    }
}
