package test.spring5.spring_dep_injection.services;

public class PetServiceFactory {

    public PetService getPetService(String petType){

        switch(petType){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }
}
