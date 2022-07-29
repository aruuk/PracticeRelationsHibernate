package org.example.dao;

import org.example.config.Config;
import org.example.entity.Car;
import org.example.entity.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class CarDao {
    public void saveCar(Long id, Car car){
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class,id);
        car.setPerson(person);
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Car> getCarsByPersonId(Long id){
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class,id);
        List<Car> cars = person.getCars();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cars;
    }

    public List<Car> getCarsByPersonName(String name){
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager
                .createQuery("select p from Person p where p.firstName = :firstName",Person.class)
                .setParameter("firstName",name)
                .getSingleResult();
        List<Car> cars = person.getCars();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cars;
    }
}
