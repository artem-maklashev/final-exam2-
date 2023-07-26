package animalsReester.view.consoleUI;

import java.util.ArrayList;
import java.util.List;

import animalsReester.view.View;
import animalsReester.view.consoleUI.menu.MenuItem;

public class Menu {
    View view;
    List<MenuItem> menuItems;

    public Menu(View view) {
        this.view = view;
        this.menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        this.menuItems.add(item);
    }

    public View getView() {
        return this.view;
    }

    public MenuItem getItem(int index) {
        return menuItems.get(index - 1);
    }

    public void printMenu() {
        int count = 1;
        for (MenuItem item : menuItems) {
            String str = String.format("%d : %s", count, item.description());
            view.message(str);
            count++;
        }
    }
}

