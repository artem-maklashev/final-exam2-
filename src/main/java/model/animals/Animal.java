package model.animals;

import java.sql.Date;

public abstract class Animal {
    private int id;
    private String name;
    private Date birthday;
    private int animal_type_id;
    private Integer type_id;
    private String commands;
    
    public Animal(int id, String name, Date birthday, int type, String commands) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.animal_type_id = type;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getType() {
        return animal_type_id;
    }

    public void setType(int type) {
        this.animal_type_id = type;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", animal_type_id=" + animal_type_id +
                ", commands='" + commands + '\'' +
                '}';
    }
}
