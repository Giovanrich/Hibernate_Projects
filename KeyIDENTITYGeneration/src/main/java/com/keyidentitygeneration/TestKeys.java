package com.keyidentitygeneration;

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

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setName("James");
        s2.setName("Timmie");
        s3.setName("Harry");

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();

        session.save(s1);
        session.save(s2);
        session.save(s3);
        trans.commit();        
        sf.close();

    }

}
