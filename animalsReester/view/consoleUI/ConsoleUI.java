package animalsReester.view.consoleUI;

import java.io.IOException;
import java.util.Scanner;

import animalsReester.presenter.Presenter;
import animalsReester.view.View;
import animalsReester.view.consoleUI.Menu;
import animalsReester.view.consoleUI.menu.AddAnimal;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;

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
        mainMenu.printMenu();
        int choice = Integer.parseInt(scan("Please enter your choice: "));
        mainMenu.getItem(choice).run();
    }

    public String scan(String message) {
        message(message);
        return scanner.nextLine();
    }
}
