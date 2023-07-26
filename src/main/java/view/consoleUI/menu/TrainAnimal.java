package view.consoleUI.menu;

import view.View;

import java.io.IOException;



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

