
import model.DBconnection;
import presenter.Presenter;
import view.View;
import view.consoleUI.ConsoleUI;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        View view = new ConsoleUI();
        DBconnection dBconnection = new DBconnection();
        Presenter presenter = new Presenter(view, dBconnection);
        view.setPresenter(presenter);
        view.start();
    }
}
