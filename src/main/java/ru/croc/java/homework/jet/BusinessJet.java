package ru.croc.java.homework.jet;

import java.time.format.DateTimeFormatter;

/**
 * Класс бизнес джета
 */
public class BusinessJet extends FlyingVehicles {
    private final String engineType;

    public BusinessJet(int id, String model, int loadCapacity, int maxHeist, int numberPassengerSeats, String engineType) {
        super(id, model, loadCapacity, maxHeist, numberPassengerSeats);
        this.engineType = engineType;
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
                "; Грузоподъемность - " + super.getLoadCapacity() +
                "; Максимальная высота - " + super.getMaxHeist() +
                "; Количество пассажирских мест - " + super.getNumberPassengerSeats() +
                "; Тип двигателя - " + engineType +
                "; id - " + super.getId();
    }
}
