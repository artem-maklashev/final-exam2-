package animalsReester.view.consoleUI.menu;

import animalsReester.view.View;

public abstract class MenuMethod implements MenuItem {
    View view;
    public MenuMethod(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    };
}
