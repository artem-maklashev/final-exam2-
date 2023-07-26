package animalsReester.view.consoleUI.menu;

import java.io.IOException;

import animalsReester.view.View;

public class TrainAnimal extends MenuMethod{

    public TrainAnimal(View view) {
        super(view);        
    }

    @Override
    public String description() {
        return "Train Animal";
    }

    @Override
    public void run() throws IOException {
        getView().trainAnimal();
    }

}  

