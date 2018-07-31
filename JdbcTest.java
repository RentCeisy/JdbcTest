package com.jdbctest;


import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class JdbcTest {

    public static void main(String[] args) {
        TestHelper testHelper = new TestHelper();

//        List<Client> clients = testHelper.getClientList();
//
//        for (Client c : clients) {
//            System.out.println(c.getId() + " " + c.getName() + " " + c.getSurname() + " " + c.getAge());
//        }
//        Client c = testHelper.getClientById(4);
//        System.out.println(c.getId() + " " + c.getName() + " " + c.getSurname() + " " + c.getAge());

//        Client client = new Client();
//        client.setName("Джошь");
//        client.setSurname("Васильев");
//        client.setAge(43);
//        testHelper.addClient(client);

//        Client client = new Client();
//        client.setAge(21);
//        client.setName("Vasiliy");
//        client.setSurname("Ivanov");
//
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(client);
//        session.getTransaction().commit();
//        session.close();
    }



}
