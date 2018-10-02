package com.myorg.hib005;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 30, 2018
 */
public class TestManyToOneMappedBy {

    public static void main(String[] args) {
        Computer c1 = new Computer();
        Computer c2 = new Computer();
        Person p1 = new Person();
        c1.setId(1);
        c1.setName("HP");
        c1.setPerson(p1);

        c2.setId(2);
        c2.setName("Dell");
        c2.setPerson(p1);

        p1.setId(102);
        p1.setName("JWizard");
        p1.getComputers().add(c1);
        p1.getComputers().add(c2);

        //Hibernate Confidurations
        Configuration conf = new Configuration().configure().addAnnotatedClass(Computer.class)
                .addAnnotatedClass(Person.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr=session.beginTransaction();
            session.save(c1);
            session.save(c2);
            session.save(p1);
            tr.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
            sf.close();
        }
    }

}
