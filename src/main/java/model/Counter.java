package model;

import java.sql.Date;

public class Counter implements AutoCloseable {
    private int value = 0;
    private String name;
    private Date birthday;
    private int animalClass;
    public boolean isUsed = false;

    public Counter(String name, Date birthday, int animalClass) {
        this.name = name;
        this.birthday = birthday;
        this.animalClass = animalClass;
    }

    public void add() {
        value++;
    }

    public void checkAllFieldsFilled() throws Exception {
        if (!isUsed || name.isEmpty() || (birthday == null)) {
            throw new Exception("Ошибка: Работа с объектом Счетчик была не в ресурсном блоке try или ресурс остался открыт. \nИли не заполнены все поля");
        }
    }

    @Override
    public void close() throws Exception {
        checkAllFieldsFilled();
    }
}
