package view.consoleUI;



import presenter.Presenter;
import view.View;
import view.consoleUI.menu.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

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
    public void start() throws IOException, SQLException {
        Menu mainMenu = new Menu(this);
        mainMenu.addItem(new AddAnimal(this));
        mainMenu.addItem(new ShowCommands(this));
        mainMenu.addItem(new TrainAnimal(this));
        mainMenu.addItem(new ShowAnimals(this));
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
    public void showAnimals() throws SQLException, IOException {
        presenter.showAnimals();
    }

    @Override
    public void exit() {
        mainFlag = false;    }   

    

}
