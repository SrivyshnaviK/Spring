package com.vyshnavi;

import com.vyshnavi.entity.Instructor;
import com.vyshnavi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try{
            //Instructor instructor=new Instructor("Srivyshnavi","Koduri","srivyk@gmail.com");
            //InstructorDetail instructorDetail=new InstructorDetail("http://www.SrivyshnaviKoduri/youtube","Love 2 Code!!!");
            Instructor instructor=new Instructor("Srivydhruthi","Koduri","srivyk@gmail.com");
            InstructorDetail instructorDetail=new InstructorDetail("http://www.SrivydhruthiKoduri/youtube","Love 2 Dance!!!");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving Instructor..."+instructor);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
