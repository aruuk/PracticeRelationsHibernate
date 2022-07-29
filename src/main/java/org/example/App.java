package org.example;

import org.example.config.Config;
import org.example.dao.CarDao;
import org.example.dao.PersonDao;
import org.example.entity.Car;
import org.example.entity.Person;

import javax.persistence.EntityManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
//        carDao.saveCar(1L,new Car("Lexus","600",200000));
        System.out.println(carDao.getCarsByPersonId(1L));

    }
}
