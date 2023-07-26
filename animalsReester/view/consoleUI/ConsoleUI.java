package animalsReester.view.consoleUI;

import java.io.IOException;
import java.util.Scanner;

import animalsReester.presenter.Presenter;
import animalsReester.view.View;
import animalsReester.view.consoleUI.menu.AddAnimal;
import animalsReester.view.consoleUI.menu.Exit;
import animalsReester.view.consoleUI.menu.ShowCommands;
import animalsReester.view.consoleUI.menu.TrainAnimal;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean mainFlag = true;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void message(String message) {
        System.out.println(message);
    }

    @Override
    public void addAnimal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAnimal'");
    }

    @Override
    public void start() throws IOException {
        Menu mainMenu = new Menu(this);
        mainMenu.addItem(new AddAnimal(this));
        mainMenu.addItem(new ShowCommands(this));
        mainMenu.addItem(new TrainAnimal(this));
        mainMenu.addItem(new Exit(this));
        while (mainFlag == true) {
            mainMenu.printMenu();
            int choice = Integer.parseInt(scan("Please enter your choice: "));
            mainMenu.getItem(choice).run();            
        }
    }

    public String scan(String message) {
        message(message);
        return scanner.nextLine();
    }

    @Override
    public void showCommands() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showCommands'");
    }

    @Override
    public void trainAnimal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trainAnimal'");
    }

    @Override
    public void showAnimals() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showAnimals'");
    }

    @Override
    public void exit() {
        mainFlag = false;
    }

}
