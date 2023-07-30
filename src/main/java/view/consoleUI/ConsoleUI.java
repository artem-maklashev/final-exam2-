package view.consoleUI;

import model.Counter;
import model.animals.Animal;
import presenter.Presenter;
import view.View;
import view.consoleUI.menu.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean mainFlag = true;

    public ConsoleUI() {
        scanner = new Scanner(in);
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
    public void addAnimal() throws SQLException, IOException {
        String name = scan("Input animal's name");
        Date birthday;
        while (true) {
            String sDate = scan("Input animal's birthday (format 'yyyy-MM-dd')");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                birthday = Date.valueOf(sDate);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong date format. Please try again.");
            }
        }
        int selectedClass = selectClass();
        try (Counter counter = new Counter(name, birthday, selectedClass)) {
            counter.add();
            counter.isUsed = true;
            presenter.addAnimal(name, birthday, selectedClass);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start() throws IOException, SQLException, ParseException {
        Menu mainMenu = new Menu(this);
        mainMenu.addItem(new AddAnimal(this));
        mainMenu.addItem(new setClass(this));
        mainMenu.addItem(new ShowCommands(this));
        mainMenu.addItem(new TrainAnimal(this));
        mainMenu.addItem(new ShowAnimals(this));
        mainMenu.addItem(new Exit(this));
        while (mainFlag == true) {
            System.out.println("Основное меню:");
            mainMenu.printMenu();
            int choice;
            while(true){
                choice = scanInt("Please enter your choice: ");
                if (choice>0 && choice <7) {
                    break;
                }
            }
            mainMenu.getItem(choice).run();
        }
    }

    public String scan(String message) {
        message(message);
        String result = scanner.nextLine();
        return result;
    }

    public int scanInt(String message) {
        boolean scanFlag = false;
        int id = 0;
        while (!scanFlag) {
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
        scanner.nextLine();
        return id;
    }

    @Override
    public void showCommands() throws SQLException, IOException {
        int id = scanInt("Input animal number: ");
        String tableName = "Animals";
        boolean isAnimalPresent = presenter.checkAnimalNumber(tableName, id);
        if (isAnimalPresent) {
            String command = presenter.showCommands(id);
            message("У животного следующие команды: " + command);
        }
    }

    @Override
    public void trainAnimal() throws SQLException, IOException {
        int id = scanInt("Input animal number: ");
        String tableName = "Animals";
        boolean isAnimalPresent = presenter.checkAnimalNumber(tableName, id);
        if (isAnimalPresent) {
//            scanner.next();
            message("Животное найдено ");
            Animal animal = presenter.takeAnimal(id);
            String newComand = scan("Введите новую команду");
            try {
                presenter.updateComand(animal, newComand);
            } catch (IOException ex) {
                message("Ошибка ввода-вывода");
                message(ex.getMessage());
            } catch (SQLException ex) {
                message("Ошибка работы с БД");
                message(ex.getMessage());
                scanner.nextLine();
            }
        } else {
            message("Животное не найдено ");
        }
    }

    @Override
    public void showAnimals() throws SQLException, IOException {
        List<Animal> animals = presenter.showAnimals();
        Map<Integer, String> animalsMap = presenter.getMap("animals_type", "animal_type");
        Map<Integer, String> kindAnimals = presenter.getMap("animals_kind", "type");
        String[] headers = {"№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды"};
        System.out.format("%5s %15s %15s %15s %14s %50s\n", "№", "Тип животного", "Вид животного", "Имя", "Дата рождения", "Команды");
        System.out.println();
        for (Animal animal : animals) {
            System.out.format("%5s %15s %15s %15s %14s %50s\n",
                    animal.getId(),
                    animalsMap.get(animal.getAnimalTypeId()),
                    kindAnimals.get(animal.getKindId()),
                    animal.getName(),
                    (animal.getBirthDate()).toString(),
                    animal.getComand());
        }
    }

    @Override
    public void exit() {
        mainFlag = false;
    }

    @Override
    public void setClass() throws SQLException, IOException {
        int id = scanInt("Input animal number: ");
        String tableName = "Animals";
        boolean isAnimalPresent = presenter.checkAnimalNumber(tableName, id);
        if (isAnimalPresent) {
//            scanner.next();

            message("Животное найдено ");
            Animal animal = presenter.takeAnimal(id);
//            Map<Integer, String> animalsKind = presenter.getMap("animals_kind", "type");
//            for (Map.Entry<Integer, String> entry : animalsKind.entrySet()) {
//                System.out.println(entry.getKey() + ". " + entry.getValue());
//            }
//            int newClass = 0;
//            boolean correctClass = false;
//            while (correctClass) {
//                newClass = scanInt("Введите класс:");
//                if(newClass > 0 || newClass <= animalsKind.size()) {
//                    correctClass = true;
//                } else {
//                    message("Invalid class " + newClass);
//                    message("Попробуйте еще раз");
//                }
//            }
            int newClass = selectClass();
            try {
                presenter.updateClass(animal, newClass);
            } catch (IOException ex) {
                message("Ошибка ввода-вывода");
                message(ex.getMessage());
            } catch (SQLException ex) {
                message("Ошибка работы с БД");
                message(ex.getMessage());
            }
        } else {
            message("Животное не найдено ");
        }

    }

    public int selectClass() throws SQLException, IOException {
        Map<Integer, String> animalsKind = presenter.getMap("animals_kind", "type");
        for (Map.Entry<Integer, String> entry : animalsKind.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        int newClass = 0;
        boolean correctClass = false;
        while (!correctClass) {
            newClass = scanInt("Введите класс:");
            if (newClass > 0 || newClass <= animalsKind.size()) {
                correctClass = true;
            } else {
                message("Invalid class " + newClass);
                message("Попробуйте еще раз");
            }
        }
        return newClass;
    }

}
