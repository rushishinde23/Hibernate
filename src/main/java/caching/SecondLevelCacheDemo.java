package caching;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session1=factory.openSession();
        Student student1=(Student) session1.get(Student.class,10);
        System.out.println(student1);
        session1.close();

//        Session session2=factory.openSession();
//        Student student2=(Student) session1.get(Student.class,10);
//        System.out.println(student2);
//        session2.close();

        factory.close();
    }
}
