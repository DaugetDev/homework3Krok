package ru.croc.java.homework;

import ru.croc.java.homework.car.PassengerCar;
import ru.croc.java.homework.car.Truck;
import ru.croc.java.homework.individualMobility.MonoWheel;
import ru.croc.java.homework.individualMobility.Scooter;
import ru.croc.java.homework.jet.BusinessJet;
import ru.croc.java.homework.jet.Helicopter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DemonstrationOfTheWork {
    public static void main(String[] args) {
        ControllerCompany company = new ControllerCompany();
        company.addTransport(new Helicopter(1, "ми-38", 2000, 5000, 20, "Пассажирский"));
        company.addTransport(new Helicopter(2, "ми-8", 5000, 4000, 4, "Грузовой"));
        company.addTransport(new MonoWheel(3, "ninebot z10", 1, 50, 10, true));
        company.addTransport(new BusinessJet(4, "Falcon 900", 10000, 8000, 10, "Реактивный"));
        company.addTransport(new Scooter(5, "Kugoo g2", 2, 100, false, 2));
        company.addTransport(new PassengerCar(6, "ВАЗ 2114", "Хэтчбек", 5, 300));
        company.addTransport(new Truck(7, "FORD f-650", "Пикап", 10000, true, false));
        company.lease(10, 1);
        company.lease(100, 3);
        company.lease(20, 4);
        company.lease(1000, 6);
        company.lease(100, 7);
        System.out.println("Т.С. в аренде на текущий момент");
        System.out.println(company.getRentedCars(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        System.out.println("\n\nТ.С. которые будут в аренде через 120 часов");
        System.out.println(company.getRentedCars(LocalDateTime.now().plusHours(120).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        System.out.println("\n\nТ.С. которые доступны для аренды");
        System.out.println(company.findFreeCars(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        System.out.println("\n\nПолный отчет");
        System.out.println(company.getReport());
        System.out.println("\n\nПолный отчет после удаления транспортного средства под id 5");
        company.removeTransport(5);
        System.out.println(company.getReport());
        System.out.println("\n\nПолный отчет после возврата транспортного средства под id 7");
        company.endLease(7);
        System.out.println(company.getReport());


    }
}