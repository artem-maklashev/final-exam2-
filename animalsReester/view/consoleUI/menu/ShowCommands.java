package animalsReester.view.consoleUI.menu;

import java.io.IOException;

import animalsReester.view.View;

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
