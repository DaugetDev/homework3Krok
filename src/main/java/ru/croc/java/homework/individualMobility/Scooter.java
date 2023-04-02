package ru.croc.java.homework.individualMobility;

import java.time.format.DateTimeFormatter;
/**
 * Класс электро самоката
 */
public class Scooter extends IndividualMobility{
    private final boolean seatAvailability;
    private final int numberMotors;

    public Scooter(int id, String model, int powerKilowatts, int batteryCapacity, boolean seatAvailability, int numberMotors) {
        super(id, model, powerKilowatts, batteryCapacity);
        this.seatAvailability = seatAvailability;
        this.numberMotors = numberMotors;
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
                "; Мощность в киловаттах - " + super.getPowerKilowatts() +
                "; Ёмкость батареи - " + super.getBatteryCapacity() +
                "; Наличие сиденья: " + (seatAvailability ? "Да": "Нет") +
                "; Количество моторов - " + numberMotors +
                "; id - " + super.getId();
    }
}
