package org.example;




import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("hibernate configuration done..");

//        Student student=new Student();
//        student.setId(104);
//        student.setName("Ashish");
//        student.setCity("Nanded");

        Address address=new Address();
        address.setStreet("strees 17,bhagya nagar");
        address.setCity("nanded");
        address.setOpen(false);
        address.setAddedDate(new Date());
        address.setX(10.2334);

        //reading image:-
        FileInputStream fis=new FileInputStream("src/main/rushi.jpeg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        address.setImage(data);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();



        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        //session.persist(student);
        session.persist(address);
        tx.commit();

        session.close();
        sessionFactory.close();


    }
}
