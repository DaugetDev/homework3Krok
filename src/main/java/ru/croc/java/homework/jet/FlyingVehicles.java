package ru.croc.java.homework.jet;

import ru.croc.java.homework.Transport;

import java.time.format.DateTimeFormatter;
/**
 * Класс летательного транспортного средства
 */

public class FlyingVehicles extends Transport {

    private final int loadCapacity;
    private final int maxHeist;
    private final int numberPassengerSeats;

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getMaxHeist() {
        return maxHeist;
    }

    public int getNumberPassengerSeats() {
        return numberPassengerSeats;
    }

    public FlyingVehicles(int id, String model, int loadCapacity, int maxHeist, int numberPassengerSeats) {
        super(id, model);
        this.loadCapacity = loadCapacity;
        this.maxHeist = maxHeist;
        this.numberPassengerSeats = numberPassengerSeats;
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
                "; Грузоподъемность - " + loadCapacity +
                "; Максимальная высота - " + maxHeist +
                "; Количество пассажирских мест - " + numberPassengerSeats +
                "; id - " + super.getId();
    }
}
