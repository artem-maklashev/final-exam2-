package view.consoleUI.menu;


import view.View;

public class AddAnimal extends MenuMethod{
    private View view;

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
