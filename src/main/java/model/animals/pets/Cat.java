package model.animals.pets;

import model.animals.Animal;

import java.sql.Date;



public class Cat extends PetsAnimals {

    public Cat(int id, int animalTypeId, int kindId, String name, Date birthDate, String comand) {
        super(id, animalTypeId, kindId, name, birthDate, comand);
        kindId = 1;
    }
  
   
    
}
