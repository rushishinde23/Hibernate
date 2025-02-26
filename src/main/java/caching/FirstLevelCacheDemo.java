package caching;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

        Student student = (Student) session.get(Student.class,15);
        System.out.println(student);
        System.out.println("working on something.....");
        Student student1=session.get(Student.class,15);
        System.out.println(student1);

        System.out.println(session.contains(student1));

        session.close();
        sessionFactory.close();
    }
}
