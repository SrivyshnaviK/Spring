package com.vyshnavi;

import com.vyshnavi.entity.Course;
import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import com.vyshnavi.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id=10;
            Course course=session.get(Course.class,id);
            System.out.println("Course with ID:"+id+" "+course);
            System.out.println("Course Reviews:"+course.getReviews());

            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
