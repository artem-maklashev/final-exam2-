package view.consoleUI.menu;

import view.View;

import java.io.IOException;


public class ShowCommands extends MenuMethod {

    public ShowCommands(View view) {
        super(view);        
    }

    @Override
    public String description() {
        return "Show commands";
    }

    @Override
    public void run() throws IOException {
        getView().showCommands();
    }

}
