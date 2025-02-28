package xmlMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingDemo {
    public static void main(String[] args) {

//        Patient patient=new Patient();
//        patient.setId(101);
//        patient.setName("Virat Kohli");
//        patient.setCity("Delhi");
//        patient.setAge(37);

        Customer customer=new Customer();
        customer.setName("Rohit Sharma");
        customer.setPhonenumber("8899889900");

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        //session.save(patient);
        session.save(customer);

        tx.commit();
        session.close();
        sessionFactory.close();
    }


}
