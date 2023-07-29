package model.animals.pets;

import java.sql.Date;

public class Dog extends PetsAnimals {

    public Dog(int id,  String name, Date birthDate, String comand) {
        super(id, 2, name, birthDate, comand);
    }
    
}
