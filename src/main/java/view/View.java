package view;


import presenter.Presenter;

import java.io.IOException;
import java.sql.SQLException;



public interface View {
    void setPresenter(Presenter presenter);

    void message(String message);

    void addAnimal();

    void start() throws IOException, SQLException;

    void showCommands();

    void trainAnimal();

    void showAnimals() throws SQLException, IOException;

    void exit();
}
