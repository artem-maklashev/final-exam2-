package model.animals.pets;

import model.animals.Animal;

import java.sql.Date;



public class Cat extends Animal {

    private final int petsId = 1;
    
    public Cat(int id, int type, int petsId, String name, Date birthday, String commands) {
        super(id, name, birthday, type, commands);        
    }

    public int getPetsId() {
        return petsId;
    }

    @Override
    public String toString() {
        return super.toString() + ", type_id=" +petsId;
    }
}
