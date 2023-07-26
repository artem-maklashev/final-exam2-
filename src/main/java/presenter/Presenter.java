package presenter;

import model.DBconnection;
import model.animals.pets.Cat;
import view.View;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Presenter {
    private View view;
    private DBconnection dbConnection;

      
    public Presenter(View view, DBconnection dbConnection) {
        this.view = view;
        this.dbConnection = dbConnection;
    }



    public void showAnimals() throws SQLException, IOException {        
        ResultSet rs = dbConnection.getResultSet("SELECT * FROM cats;");
        List<Cat> cats = new ArrayList<Cat>();
        while (rs.next()) {
            Cat cat = new Cat(
                    rs.getInt("id"),
                    rs.getInt("animal_type_id"),
                    rs.getInt("pets_type_id"),
                    rs.getString("name"),
                    rs.getDate("birthday"),
                    rs.getString("command"));
            cats.add(cat);
        }
        for (Cat cat : cats) {
           System.out.println(cat.toString()); 
        }
    }
    
}
