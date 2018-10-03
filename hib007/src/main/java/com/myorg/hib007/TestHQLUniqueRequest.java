package com.myorg.hib007;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Oct 2, 2018
 */
public class TestHQLUniqueRequest {

    public static void main(String[] args) {

        Student s1 = null;

        //Hib Configurations
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Student where id=0");
        try {
            session.beginTransaction();
            s1=(Student)query.uniqueResult();
            System.out.println(s1);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sf.close();
            session.close();
        }
    }

}
