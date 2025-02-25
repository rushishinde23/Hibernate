package org.example;

import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        Student student=(Student) session.get(Student.class,105);

        System.out.println(student);

//        Address address=(Address) session.get(Address.class,2);
//        System.out.println(address);



        session.close();
        sessionFactory.close();
    }
}
