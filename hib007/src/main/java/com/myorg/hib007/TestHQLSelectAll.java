package com.myorg.hib007;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Oct 2, 2018
 */
public class TestHQLSelectAll {

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Student> students=null;
        
        try {
            tr = session.beginTransaction();
            Query selectAllQuerry=session.createQuery("from Student");
            students=selectAllQuerry.list();
            

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            sf.close();
            session.close();
        }
        
        
        //Print all results
        for(Student s: students){
            System.out.println(s);
        }
        
        
        
    }

}
