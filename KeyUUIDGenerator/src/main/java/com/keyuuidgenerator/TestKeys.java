package com.keyuuidgenerator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @Created on Jan 22, 2019
 * @author chiraran (Giovanrich/JWizard)
 */
public class TestKeys {

    public static void main(String[] args) {

        Car c1 = new Car();
        Car c2 = new Car();

        c1.setModel("Auto Bio");
        c2.setModel("Cruizer");
        Configuration con = new Configuration().configure().addAnnotatedClass(Car.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();

        session.save(c1);
        session.save(c2);

        trans.commit();

        sf.close();

    }

}
