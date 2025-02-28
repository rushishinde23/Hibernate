package validations;

import jakarta.validation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class ValidationsDemo {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setId(10);
        user.setName("Jo");
        user.setAge(17);
        user.setEmail("invalid-email");
        user.setPhoneNumber("12345");

        User user2=new User();
        user2.setId(12);
        user2.setName("rushi");
        user2.setAge(23);
        user2.setEmail("123rushi@gmail.com");
        user2.setPhoneNumber("1234567898");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }

        } else {
            System.out.println("User is valid!");
            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();
              session.persist(user2);
              tx.commit();
            session.close();
            sessionFactory.close();
        }



    }
}
