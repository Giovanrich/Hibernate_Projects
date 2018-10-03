
package com.myorg.hib007;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
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
public class TestHQLTransformResultSet {
    public static void main(String[] args) {

        //Hib Configurations
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        int b = 10;
        SQLQuery q = session.createSQLQuery("select student_id,name from students where student_id>:b");
        q.setParameter("b", b);
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        
        try {
            session.beginTransaction();
            List students=q.list();
            for(Object o:students){
                Map m=(Map)o;
                System.out.println(m.get("student_id")+"......."+m.get("name"));
            }
            

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sf.close();
            session.close();
        }
    }
}
