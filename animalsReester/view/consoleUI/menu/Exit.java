package animalsReester.view.consoleUI.menu;

import java.io.IOException;

import animalsReester.view.View;

public class Exit extends MenuMethod{

    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Exit";
    }

    @Override
    public void run() throws IOException {
        getView().exit();
    }

}
