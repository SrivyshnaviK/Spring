package com.vyshnavi;

import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id=7;
            Instructor instructor=session.get(Instructor.class,id);
            System.out.println("Instructor with Id:3"+instructor);
            if(instructor!=null){
                System.out.println("Deleting Instructor..."+instructor);
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done!!!");
            session.close();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
