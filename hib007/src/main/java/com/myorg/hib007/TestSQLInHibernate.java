package com.myorg.hib007;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Oct 2, 2018
 */
public class TestSQLInHibernate {

    public static void main(String[] args) {

        //Hib Configurations
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        int b = 10;
        SQLQuery q = session.createSQLQuery("select * from students where student_id>:b");
        q.setParameter("b", b);
        q.addEntity(Student.class);
        try {
            session.beginTransaction();
            List<Student> students=q.list();
            for(Student o:students){
                System.out.println(o);
            }
            

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sf.close();
            session.close();
        }
    }
}
