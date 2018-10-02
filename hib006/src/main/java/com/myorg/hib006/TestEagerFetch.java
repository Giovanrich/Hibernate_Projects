package com.myorg.hib006;

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
public class TestEagerFetch {

    public static void main(String[] args) {
        Kid k1 = new Kid();
        Pencil p1 = new Pencil();
        Pencil p2 = new Pencil();

        p1.setId(1);
        p1.setName("HB");
        p1.setKid(k1);

        p2.setId(2);
        p2.setName("Hard Penci");
        p2.setKid(k1);

        k1.setId(101);
        k1.setName("Jim");
        k1.getPencil().add(p1);
        k1.getPencil().add(p2);

        //HB configuration, insert, then fetch
        Configuration conf = new Configuration().configure().addAnnotatedClass(Kid.class)
                .addAnnotatedClass(Pencil.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr=session.beginTransaction();
            //session.save(p1);
            //session.save(p2);
            //session.save(k1);            
            Kid kid=(Kid)session.get(Kid.class,101);
            System.out.println("Kid........."+kid);
            tr.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            sf.close();
            session.close();

        }

    }

}
