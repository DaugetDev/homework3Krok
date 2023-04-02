package ru.croc.java.homework.individualMobility;

import ru.croc.java.homework.Transport;
/**
 * Класс транспорта
 */
public class IndividualMobility extends Transport {
    private final int powerKilowatts;
    private final int batteryCapacity;

    public IndividualMobility(int id, String model, int powerKilowatts, int batteryCapacity) {
        super(id, model);
        this.powerKilowatts = powerKilowatts;
        this.batteryCapacity = batteryCapacity;
    }

    public int getPowerKilowatts() {
        return powerKilowatts;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
    /**
     * Получение полной информации о Транспорте
     * @return Строка содержащая всю информацию о транспорте
     */
    @Override
    public String getInfo(){
        return "Модель - " + super.getModel() +
                "; Мощность в киловаттах - " + powerKilowatts +
                "; Ёмкость батареи - " + batteryCapacity +
                "; id - " + super.getId();
    }
}
