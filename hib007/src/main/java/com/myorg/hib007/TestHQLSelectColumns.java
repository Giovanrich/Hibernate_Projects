package com.myorg.hib007;

import java.util.List;
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
public class TestHQLSelectColumns {

    public static void main(String[] args) {

        //Hib Configurations
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        //Query query = session.createQuery("select id,course from Student where id=1");
        Query query = session.createQuery("select id,course from Student");
        try {
            session.beginTransaction();
            List< Object[]> students = (List<Object[]>) query.list();

            for (Object[] student : students) {
                System.out.println(student[0] + ",,,," + student[1]);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sf.close();
            session.close();
        }
    }
}
