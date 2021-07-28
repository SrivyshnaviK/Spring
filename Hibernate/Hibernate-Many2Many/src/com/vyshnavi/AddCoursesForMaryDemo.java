package com.vyshnavi;

import com.vyshnavi.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
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
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());
            Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            System.out.println("\nSaving the courses ...");
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
