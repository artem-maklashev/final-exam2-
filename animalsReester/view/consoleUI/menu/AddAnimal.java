package animalsReester.view.consoleUI.menu;

import animalsReester.view.View;

public class AddAnimal extends MenuMethod{

    public AddAnimal(View view) {
        super(view);
    }
    
    @Override
        public void run() {
            getView().addAnimal();
        }

    @Override
    public String description() {
        return "Add an animal";
    }
}
