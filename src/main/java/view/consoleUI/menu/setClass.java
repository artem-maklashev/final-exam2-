package view.consoleUI.menu;

import view.View;

import java.io.IOException;
import java.sql.SQLException;

public class setClass extends MenuMethod{
    public setClass(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Set animal class";
    }

    @Override
    public void run() throws IOException, SQLException {
        getView().setClass();
    }
}
