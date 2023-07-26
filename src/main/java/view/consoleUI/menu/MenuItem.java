package view.consoleUI.menu;

import java.io.IOException;
import java.sql.SQLException;

public interface MenuItem {
    String description();
    void run() throws IOException, SQLException;
}

