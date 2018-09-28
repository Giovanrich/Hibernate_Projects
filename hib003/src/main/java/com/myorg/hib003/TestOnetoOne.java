package com.myorg.hib003;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 28, 2018
 */
public class TestOnetoOne {

    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.setId(1);
        acc1.setAcc_number("1234");
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Nation");
        emp1.setAccount(acc1);

        Configuration conf = new Configuration().configure().addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Account.class);
        System.out.println("After config");
        SessionFactory sf = conf.buildSessionFactory();
         System.out.println("After building sf");
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr=session.beginTransaction();
            session.save(acc1);
            session.save(emp1);
            tr.commit();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
            session.close();
            sf.close();

        } finally {
            if (session != null) {
                session.close();
                System.out.println("After closing session");
            }
            if (sf != null) {
                sf.close();
                System.out.println("After closing sf");
            }
        }

    }

}
