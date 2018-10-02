package com.myorg.hib004;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 29, 2018
 */
public class TestOnetoMany {

    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setId(1);
        l1.setName("650");
        Laptop l2 = new Laptop();
        l2.setId(2);
        l2.setName("650 Pavillion");

        Student s1 = new Student();
        s1.setRollNumber(101);
        s1.getLaptops().add(l1);
        s1.getLaptops().add(l2);

        Configuration conf = new Configuration().configure().
                addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(l1);
            session.save(l2);
            session.save(s1);
            tr.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (sf != null) {
                sf.close();
            }
            if (session != null) {
                session.close();
            }
        }

    }

}
