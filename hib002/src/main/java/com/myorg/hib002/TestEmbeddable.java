package com.myorg.hib002;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 27, 2018
 */
public class TestEmbeddable {

    public static void main(String[] args) {
        Name u1Name=new Name();
        u1Name.setFname("Nation");
        u1Name.setMname("JWizard");
        u1Name.setLname("Chirara");

        User u1 = new User();
        u1.setId(1);
        u1.setAname(u1Name);
        u1.setAddress("Some Address");
        

        Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(u1);
            trns.commit();
        } catch (HibernateException e) {
            if(trns!=null){trns.rollback();}
            e.printStackTrace();            
        }finally{
            sf.close();
            session.close();
        }

    }

}
