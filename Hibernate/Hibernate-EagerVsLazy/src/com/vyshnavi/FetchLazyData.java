package com.vyshnavi;

import com.vyshnavi.entity.Course;
import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchLazyData {
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
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:theInstructorId",
                            Instructor.class);
            query.setParameter("theInstructorId", id);

            Instructor instructor= query.getSingleResult();
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
