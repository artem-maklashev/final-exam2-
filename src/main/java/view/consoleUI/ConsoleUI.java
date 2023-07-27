package view.consoleUI;



import presenter.Presenter;
import view.View;
import view.consoleUI.menu.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.animals.Animal;

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
        List<Animal> animals = presenter.showAnimals();
        Map<Integer, String> animalsMap = presenter.getMap("animals_type", "animal_type");
        Map<Integer, String> kindAnimals = presenter.getMap("animals_kind", "type");
        String[] headers = {"№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды"};
        System.out.format("%5s%15s%15s%15s%12s%50s\n","№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды");
        System.out.println();
        for (Animal animal : animals) {
            System.out.format("%5s %15s %15s %15s %12s %50s\n",
                    animal.getId() + " " +                
                    animalsMap.get(animal.getAnimalTypeId()) + " " +
                    kindAnimals.get(animal.getKindId()) + " " +
                    animal.getName() + " " +
                    (animal.getBirthDate()).toString() + " " +
                    animal.getComand());
        } 
    }

    @Override
    public void exit() {
        mainFlag = false;    }   

    

}
