package ru.croc.java.homework.car;

import java.time.format.DateTimeFormatter;

/**
 * Класс пассажирского автомобиля
 */
public class PassengerCar extends Car{
    private final int numberPassengerSeats;
    private final int distanceOnOneTank;

    public PassengerCar(int id, String model, String bodyType, int numberPassengerSeats, int distanceOnOneTank) {
        super(id, model, bodyType);
        this.numberPassengerSeats = numberPassengerSeats;
        this.distanceOnOneTank = distanceOnOneTank;
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
                "; Количество пассажирских мест - " + numberPassengerSeats +
                "; Расстояние, которое можно преодолеть на 1 баке - " + distanceOnOneTank +
                "; id - " + super.getId();
    }
}
