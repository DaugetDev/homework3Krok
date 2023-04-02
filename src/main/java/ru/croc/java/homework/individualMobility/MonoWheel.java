package ru.croc.java.homework.individualMobility;

import java.time.format.DateTimeFormatter;
/**
 * Класс моноколеса
 */
public class MonoWheel extends IndividualMobility{

    private final int angleOfInclination;
    private final boolean protectionFromMoisture;

    public MonoWheel(int id, String model, int powerKilowatts, int batteryCapacity, int angleOfInclination, boolean protectionFromMoisture) {
        super(id, model, powerKilowatts, batteryCapacity);
        this.angleOfInclination = angleOfInclination;
        this.protectionFromMoisture = protectionFromMoisture;
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
                "; Защита от влаги: " + (protectionFromMoisture ? "Да": "Нет") +
                "; Максимальный угол наклона - " + angleOfInclination +
                "; id - " + super.getId();
    }
}
