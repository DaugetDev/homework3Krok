package ru.croc.java.homework.car;

import java.time.format.DateTimeFormatter;

/**
 * Класс грузового автомобиля
 */
public class Truck extends Car{
    private final int loadCapacity;
    private final boolean openBody;
    private final boolean dangerousGoods;

    public Truck(int id, String model, String bodyType, int loadCapacity, boolean openBody, boolean dangerousGoods) {
        super(id, model, bodyType);
        this.loadCapacity = loadCapacity;
        this.openBody = openBody;
        this.dangerousGoods = dangerousGoods;
    }
    /**
     * Получение полной информации о Транспорте
     * @return Строка содержащая всю информацию о транспорте
     */
    @Override
    public String getInfo(){
        return "Модель - " + super.getModel() +
                (super.getTimeEndLease() != null ? "; В аренде до " +
                        super.getTimeEndLease().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) :
                        "; Не в аренде") +
                "; Тип кузова - " + super.getBodyType() +
                "; Грузоподъемность - " + loadCapacity +
                "; Открытый кузов: " + (openBody ? "Да": "Нет") +
                "; Допустимость для перевозки опасных грузов: " + (dangerousGoods ? "Да": "Нет") +
                "; id - " + super.getId();
    }
}
