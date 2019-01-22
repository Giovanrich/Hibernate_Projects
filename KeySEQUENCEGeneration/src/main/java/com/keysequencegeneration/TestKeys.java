package com.keysequencegeneration;

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
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        u1.setName("James");
        u2.setName("Billy");
        u3.setName("Julie");
        u4.setName("Hazel");
        
        Configuration con= new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        
        session.save(u1);
        session.save(u2);
        session.save(u3);
        session.save(u4);
        
        trans.commit();
        sf.close();
        

    }

}
