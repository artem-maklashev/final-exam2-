package animalsReester.view;


import java.io.IOException;

import animalsReester.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void message(String message);

    void addAnimal();

    void start() throws IOException;
}
