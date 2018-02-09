package org.mitroshin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DatabaseAPI {
    private SessionFactory sessionFactory;
    private static final int ENTITIES_COUNT = 1000;

    public void connect() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void init() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < ENTITIES_COUNT; i++) {
            session.save(new MyProduct("Product" + i, i * 10));
        }
        session.getTransaction().commit();
        session.close();
    }

    public void read() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from MyProduct").list();
        for (MyProduct product : (List<MyProduct>) result) {
            System.out.println(product);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void getPrice(String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from MyProduct as myProduct where title = :title");
        query.setParameter("title", title);
        MyProduct product = (MyProduct) query.getSingleResult();
        System.out.println(product.getCost());

        session.getTransaction().commit();
        session.close();
    }

    public void changePrice(String title, int newPrice) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("update MyProduct set cost = :newPrice where title = :title")
                .setParameter("title", title)
                .setParameter("newPrice", newPrice);
        int result = query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void getProductsWithinPriceRange(int lowPrice, int highPrice) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from MyProduct where cost between :lowPrice and :highPrice")
                .setParameter("lowPrice", lowPrice)
                .setParameter("highPrice", highPrice);
        List products = query.getResultList();
        for (MyProduct product : (List<MyProduct>) products) {
            System.out.println(product);
        }

        session.getTransaction().commit();
        session.close();
    }
}
