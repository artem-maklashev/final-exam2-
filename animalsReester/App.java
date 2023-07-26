package animalsReester;

import java.io.IOException;

import animalsReester.view.View;
import animalsReester.view.consoleUI.ConsoleUI;

public class App {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        view.start();
    }
}
