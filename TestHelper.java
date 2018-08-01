package com.jdbctest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class TestHelper {
    private SessionFactory sessionFactory;

    public TestHelper() {
        sessionFactory = FactoryHelper.getSessionFactory();
    }

    public List<Client> getClientList() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

    public List<Client> getClientList1() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        Selection[] selections = {root.get("id"), root.get("name")};
        criteriaQuery.select(criteriaBuilder.construct(Client.class, selections));
        Query query = session.createQuery(criteriaQuery);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

    public List<Client> getClientList2() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        Selection[] selections = {root.get("id"), root.get("name")};
        criteriaQuery.select(criteriaBuilder.construct(Client.class, selections)).where(criteriaBuilder.equal(root.<String>get("name"), "Mila"));
        Query query = session.createQuery(criteriaQuery);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    public Client getClientById(long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }
}
