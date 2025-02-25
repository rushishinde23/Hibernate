package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingDemo {
    public static void main(String[] args) {

        Question question1=new Question();
        question1.setQuestionID(101);
        question1.setQuestion("What is hibernate?");

        Answer answer1=new Answer();
        answer1.setAnswerId(211);
        answer1.setAnswer("hibernate is complete solution for automatic persistance in db in java");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);


        Question question2=new Question();
        question2.setQuestionID(102);
        question2.setQuestion("what is collection?");

        Answer answer2 = new Answer();
        answer2.setAnswerId(212);
        answer2.setAnswer("collection represents group of objects");
        question2.setAnswer(answer2);
        answer2.setQuestion(question2);


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        session.persist(question1);
        session.persist(answer1);
        session.persist(question2);
        session.persist(answer2);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
