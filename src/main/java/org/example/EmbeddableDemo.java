package org.example;

import entity.Certificate;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {

//        Student student=new Student();
//        student.setId(108);
//        student.setName("Krishna Dudhate");
//        student.setCity("Pune");
//        Certificate certificate=new Certificate();
//        certificate.setCourse("SSC CGL");
//        certificate.setDuration("6 Months");
//        student.setCertificate(certificate);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        //session.persist(student);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
