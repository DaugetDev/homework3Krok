package ru.croc.java.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс управления арендой
 */
public class ControllerCompany {
    List<Transport> transport = new ArrayList<>();

    /**
     * добавляет транспорт в аренду
     * @param tr транспортное средство, которое будет добаленно
     */
    public void addTransport(Transport tr) {
        for (var elem : transport) {
            if (elem.getId() == tr.getId()) {
                return;
            }
        }
        transport.add(tr);
    }

    /**
     * Удаляет транспортное средство из аренды
     * @param id идентефикатор транспортного средства, которе будет удалено
     */
    public void removeTransport(int id) {
        for (int i = 0; i < transport.size(); i++) {
            if (transport.get(i).getId() == id) {
                transport.remove(transport.get(i));
                return;
            }
        }
    }

    /**
     * Берет в аренду транспортное средство
     * @param hours количество часов аренды
     * @param id иднетификатор транспортного средства, которое берется в аренду
     */
    public void lease(int hours, int id) {
        for (var elem : transport) {
            if (elem.getId() == id) {
                if (!elem.isLease()) {
                    elem.lease(LocalDateTime.now().plusHours(hours));
                }
            }
        }
    }

    /**
     * завершение аренды транспортного средства
     * @param id идентификатор транспортного средства
     */
    public void endLease(int id) {
        for (var elem : transport) {
            if (elem.getId() == id) {
                elem.endLease();
            }
        }
    }

    /**
     * метод который предоставляет информацию о арендованных транспортных средствах
     * @param dateTime время в какой момент необходимо просмотреть арендованные транспортные средства в формате "yyyy-MM-dd HH:mm"
     * @return Строка с полной информацией о транспортных средствх, которые к указанному моменту времени будут арендованы
     */
    public String getRentedCars(String dateTime) {
        LocalDateTime time = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        StringBuilder report = new StringBuilder();
        for (var elem : transport) {
            if (elem.getTimeEndLease() != null) {
                if (elem.getTimeEndLease().isAfter(time)) {
                    report.append(elem.getInfo()).append("\n");
                }
            }
        }
        return report.toString();
    }

    /**
     * метод который предоставляет информацию о свободных транспортных средствах
     * @param dateTime время в какой момент необходимо просмотреть свободные транспортные средства в формате "yyyy-MM-dd HH:mm"
     * @return Строка с полной информацией о транспортных средствах, которые к указанному моменту времени будут свободны
     */
    public String findFreeCars(String dateTime) {
        LocalDateTime time = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        StringBuilder reportPart1 = new StringBuilder("Автомобили: \n");
        StringBuilder reportPart2 = new StringBuilder("Средства индивидуальной мобильности: \n");
        StringBuilder reportPart3 = new StringBuilder("Летательные трансп. средства: \n");
        for (var elem : transport) {
            if (elem.getTimeEndLease() == null) {
                if (elem.getClass().getName().equals("ru.croc.java.homework.car.PassengerCar") ||
                        elem.getClass().getName().equals("ru.croc.java.homework.car.Truck")) {
                    reportPart1.append(elem.getInfo());
                } else if (elem.getClass().getName().equals("ru.croc.java.homework.individualMobility.MonoWheel") ||
                        elem.getClass().getName().equals("ru.croc.java.homework.individualMobility.Scooter")) {
                    reportPart2.append(elem.getInfo());
                } else {
                    reportPart3.append(elem.getInfo());
                }
            }
            else if (elem.getTimeEndLease().isBefore(time)){
                if (elem.getClass().getName().equals("ru.croc.java.homework.car.PassengerCar") ||
                        elem.getClass().getName().equals("ru.croc.java.homework.car.Truck")) {
                    reportPart1.append(elem.getInfo());
                } else if (elem.getClass().getName().equals("ru.croc.java.homework.car.MonoWheel") ||
                        elem.getClass().getName().equals("ru.croc.java.homework.car.Scooter")) {
                    reportPart2.append(elem.getInfo());
                } else {
                    reportPart3.append(elem.getInfo());
                }
            }
        }
        return reportPart1.append("\n").toString() + reportPart2.append("\n") + reportPart3.append("\n");
    }

    /**
     * Получение полного отчера по всем транспортным средствам
     * @return строка, содержащая полную информацию о всех транспортных средствах
     */
    public String getReport() {
        StringBuilder report = new StringBuilder();
        for (var elem : transport) {
            report.append(elem.getInfo()).append("\n");
        }
        return report.toString();
    }

}
