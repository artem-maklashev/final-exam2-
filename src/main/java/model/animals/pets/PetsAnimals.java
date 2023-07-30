package model.animals.pets;

import java.sql.Date;

import model.animals.Animal;

public class PetsAnimals extends Animal {
    
    public PetsAnimals(int id, int kindId, String name, Date birthDate, String comand) {
        super(id, 1, kindId, name, birthDate, comand);
        
    }    
    
    
}
