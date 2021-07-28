package com.vyshnavi;

import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id=1;
            InstructorDetail instructorDetail=session.get(InstructorDetail.class,id);
            System.out.println("InstructorDetail:"+instructorDetail);
            System.out.println("Associated Instructor:"+instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
