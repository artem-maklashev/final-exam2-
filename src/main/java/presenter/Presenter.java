package presenter;

import model.DBconnection;
import model.animals.Animal;
import view.View;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Presenter {
    private View view;
    private DBconnection dbConnection;

      
    public Presenter(View view, DBconnection dbConnection) {
        this.view = view;
        this.dbConnection = dbConnection;
    }



    public List<Animal> showAnimals() throws SQLException, IOException {        
        ResultSet rs = dbConnection.getResultSet("SELECT * FROM animals;");
        List<Animal> animals = new ArrayList<Animal>();
        while (rs.next()) {
            Animal animal = new Animal(
                    rs.getInt("id"),
                    rs.getInt("animal_type_id"),
                    rs.getInt("type_id"),
                    rs.getString("name"),
                    rs.getDate("birthday"),
                    rs.getString("command"));
            animals.add(animal);
        }
        // Animal animal = new Cat(1, "Name", java.sql.Date.valueOf("2023-07-27"), "рядом");
        // System.out.println(animal.getKindId());
        return animals;
    }



    public Map<Integer, String> getMap(String tableName, String fieldName) throws SQLException, IOException {
        ResultSet rs = dbConnection.getResultSet("SELECT * FROM " + tableName + ";");
        Map<Integer, String> map = new HashMap<Integer, String>();
        while (rs.next()) {
            map.put(rs.getInt("id"), rs.getString(fieldName));
        }
        return map;
    }


    public boolean checkAnimalNumber(String tableName, int id) throws SQLException, IOException {
        boolean idExist = false;
        ResultSet rs = dbConnection.getResultSet("SELECT * from " + tableName + " WHERE id = " + id + ";");
        while(rs.next()){
            idExist = true;
            break;
        }
        return idExist;
    }
}
