package ru.croc.java.homework;

import java.time.LocalDateTime;

/**
 * Класс транспорта
 */
public abstract class Transport {
    private final int id;
    private final String model;
    private LocalDateTime timeEndLease = null;

    public LocalDateTime getTimeEndLease() {
        return timeEndLease;
    }

    protected Transport(int id, String model){
        this.id = id;
        this.model = model;
    }

    /**
     * Метод взятия автомобиля в аренду
     * @param timeEndLease Время конца аренды
     */
    public void lease(LocalDateTime timeEndLease) {
        if (timeEndLease.isAfter(LocalDateTime.now()) && this.timeEndLease == null){
            this.timeEndLease = timeEndLease;
        }
    }

    protected String getModel(){
        return this.model;
    }

    public int getId(){
        return this.id;
    }

    /**
     * Проверка, можно ли взять транспорт в аренду
     * @return True, если тренспорт не арендован
     */
    public boolean isLease(){
        return this.timeEndLease != null;
    }

    /**
     * Метод оканчивающий аренду транспорта
     */
    public void endLease(){
        this.timeEndLease = null;
    }

    /**
     * Получение полной информации о Транспорте
     * @return Строка содержащая всю информацию о транспорте
     */
    public String getInfo(){
        return "Модель - " + model + "; id = " + id;
    }
}
