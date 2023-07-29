package view.consoleUI;


import model.animals.Animal;
import presenter.Presenter;
import view.View;
import view.consoleUI.menu.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
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
            int choice = scanInt("Please enter your choice: ");
            mainMenu.getItem(choice).run();            
        }
    }

    public String scan(String message) {
        message(message);
        return scanner.next();
    }

    public int scanInt(String message){
        boolean scanFlag = false;
        int id = 0;
        while(!scanFlag) {
            message(message);
            try {
                id = scanner.nextInt();
                if (id < 1) {
                    message("Номер не может быть меньше 1");
                } else {
                    scanFlag = true;
                }
            } catch (InputMismatchException ex) {
                message("Номер должен быть целым положительным числом отличным от 0");
                scanner.nextLine();
            }
        }
        return id;
    }

    @Override
    public void showCommands() throws SQLException, IOException {
        int id = scanInt("Input animal number: ");
        String tableName= "Animals";
        boolean isAnimalPresent = presenter.checkAnimalNumber(tableName, id);
        if (isAnimalPresent) {
            String command = presenter.showCommands(tableName, id);
            message("У животного следующие команды: " + command);
        }
    }

    @Override
    public void trainAnimal() throws SQLException, IOException {
        int id = scanInt("Input animal number: ");
        String tableName= "Animals";
        boolean isAnimalPresent = presenter.checkAnimalNumber(tableName, id);
        if (isAnimalPresent) {
//            scanner.next();
            message("Животное найдено ");
            String newComand = scan("Введите новую команду");
            try{
                presenter.updateComand(tableName, id, newComand);
            } catch (IOException ex) {
                message("Ошибка ввоада-вывода");
                message(ex.getMessage());
            } catch (SQLException ex){
                message("Ошибка работы с БД");
                message(ex.getMessage());
            }
        } else{
            message("Животное не найдено ");
        }
    }

    @Override
    public void showAnimals() throws SQLException, IOException {
        List<Animal> animals = presenter.showAnimals();
        Map<Integer, String> animalsMap = presenter.getMap("animals_type", "animal_type");
        Map<Integer, String> kindAnimals = presenter.getMap("animals_kind", "type");
        String[] headers = {"№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды"};
        System.out.format("%5s %15s %15s %15s %14s %50s\n","№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды");
        System.out.println();
        for (Animal animal : animals) {
            System.out.format("%5s %15s %15s %15s %14s %50s\n",
                    animal.getId() ,               
                    animalsMap.get(animal.getAnimalTypeId()) ,
                    kindAnimals.get(animal.getKindId()),
                    animal.getName() ,
                    (animal.getBirthDate()).toString() ,
                    animal.getComand());
        } 
    }

    @Override
    public void exit() {
        mainFlag = false;    }




}
