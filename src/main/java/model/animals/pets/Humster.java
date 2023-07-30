package model.animals.pets;

import java.sql.Date;

public class Humster extends PetsAnimals {

    public Humster(int id, String name, Date birthDate, String comand) {
        super(id, 3, name, birthDate, comand);
    }
    
}
