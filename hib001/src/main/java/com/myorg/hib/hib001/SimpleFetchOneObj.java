/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.hib.hib001;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author JWizard
 */
public class SimpleFetchOneObj {

    public static void main(String[] args) {
        Transaction tx = null;
        Session session = null;
        SessionFactory sf = null;
        try {
            Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            User u1 = (User) session.get(User.class, 6);
            System.out.println(u1);

        } catch (HibernateException e) {
            e.printStackTrace();
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
