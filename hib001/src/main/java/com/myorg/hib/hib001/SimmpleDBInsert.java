package com.myorg.hib.hib001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author (Nation Chirara) :JWizard
 * @Created On: Sep 26, 2018
 */
public class SimmpleDBInsert {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setId(7);
        u1.setName("Nation");
        u1.setSurname("Chirara");
        u1.setAddress("3095 Old Highfield, Harare, Zim");
        Transaction tx = null;
        Session session = null;
        try {
            Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
            SessionFactory sf = con.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(u1);
            tx.commit();
            sf.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }

    }

}
