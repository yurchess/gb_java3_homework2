package org.mitroshin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.spi.LoadedConfig;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DatabaseAPI {
    SessionFactory sessionFactory;

    public DatabaseAPI() {

        Map<String, String> settings = new HashMap<String, String>();
        settings.put("hibernate.connection.driver_class", "org.sqlite.JDBC");
        settings.put("hibernate.connection.url", "jdbc:sqlite:mysqlite.db");
        settings.put("hibernate.connection.username", "");
        settings.put("hibernate.connection.password", "");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("class", "org.mitroshin.MyProduct");

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void init() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
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
}
