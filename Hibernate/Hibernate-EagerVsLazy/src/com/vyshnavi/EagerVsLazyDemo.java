package com.vyshnavi;

import com.vyshnavi.entity.Course;
import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id=2;
            Instructor instructor=session.get(Instructor.class,id);
            System.out.println("Instructor with ID:"+id+" "+instructor);
            System.out.println("Courses associated with Instructor:"+instructor.getCourses()+"\n");
            session.getTransaction().commit();
            session.close();
            System.out.println("The Session is Closed!!!\n");
            System.out.println("Courses associated with Instructor:"+instructor.getCourses());

            System.out.println("Done!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
