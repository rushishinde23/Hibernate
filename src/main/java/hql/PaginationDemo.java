package hql;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PaginationDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

        String str="from Student";

        Query<Student>  query=session.createQuery(str, Student.class);

        query.setFirstResult(10);
        query.setMaxResults(15);

        List<Student> studentList=query.getResultList();

        for(Student student:studentList){
            System.out.println(student);
        }

        
        session.close();
        sessionFactory.close();
    }
}
