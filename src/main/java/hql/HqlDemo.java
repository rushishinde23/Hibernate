package hql;

import entity.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HqlDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
     //SELECT QUERY:-
        //String query="from Student";
        //String query="from Student where city='Nanded'";

        //String query="from Student s where s.city=:x and s.id=:y";
//        Query q=session.createQuery(query);
//        q.setParameter("x","Nanded");
//        q.setParameter("y",106);
//        List<Student> studentList=q.getResultList();
//        for(Student s:studentList){
//            System.out.println(s.getName());
//        }

        //UPDATE QUERY
//        Query q=session.createQuery("update Student set city=:x where id=:y");
//        q.setParameter("x","Parbhani");
//        q.setParameter("y",108);
//        int r=q.executeUpdate();
//        System.out.println("updated:"+r);

        //DELETE QUERY
//        Query q=session.createQuery("delete from Student s where s.city=:x");
//        q.setParameter("x","Parbhani");

//        int r=q.executeUpdate();
//        System.out.println("Deleted:"+r);


        Transaction tx=session.beginTransaction();




        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
