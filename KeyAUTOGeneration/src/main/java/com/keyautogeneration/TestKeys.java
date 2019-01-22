package com.keyautogeneration;

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

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.setName("Nation");
        p2.setName("Jack");
        p3.setName("Billy");
        //p1.setId(0);

        Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
        session.save(p2);
        session.save(p3);

        trans.commit();

    }
}
