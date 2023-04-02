package ru.croc.java.homework.car;

import ru.croc.java.homework.Transport;

/**
 * Класс автотранспорта
 */
public class Car extends Transport {
    private final String bodyType;

    public String getBodyType() {
        return bodyType;
    }

    public Car(int id, String model, String bodyType) {
        super(id, model);
        this.bodyType = bodyType;
    }
    /**
     * Получение полной информации о Транспорте
     * @return Строка содержащая всю информацию о транспорте
     */
    @Override
    public String getInfo(){
        return "Модель - " + super.getModel() +
                "; Тип кузова - " + bodyType +
                "; id - " + super.getId();
    }
}
