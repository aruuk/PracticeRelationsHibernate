package org.example.dao;

import org.example.config.Config;
import org.example.entity.Person;

import javax.persistence.EntityManager;

public class PersonDao {

    public void savePerson(Person person) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    // getALl
    // update
    // deleteById
    // getByID

}
