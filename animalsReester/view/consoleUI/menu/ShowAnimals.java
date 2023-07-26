package animalsReester.view.consoleUI.menu;

import java.io.IOException;

import animalsReester.view.View;

public class ShowAnimals extends MenuMethod {

    public ShowAnimals(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Show animals";
    }

    @Override
    public void run() throws IOException {
        getView().showAnimals();
    }

    
}
