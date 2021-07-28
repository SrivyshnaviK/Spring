package com.vyshnavi;

import com.vyshnavi.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int courseId=10;
            Course course=session.get(Course.class,courseId);
            session.delete(course);
            System.out.println("Deleted Pacman Course");
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
