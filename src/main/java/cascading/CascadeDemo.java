package cascading;


import oneToMany.Answer;
import oneToMany.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeDemo {
    public static void main(String[] args) {
        Question q=new Question();
           q.setQuestionId(102);
           q.setQuestion("What is exception?");

        Answer a1=new Answer();
        a1.setAnswerID(10201);
        a1.setAnswer("unwanted situation that disturbs normal flow of execution of program");
        a1.setQuestion(q);

        Answer a2=new Answer();
        a2.setAnswerID(10202);
        a2.setAnswer("we can handle exceptions by using try/catch block");
        a2.setQuestion(q);

        List<Answer> answerList=new ArrayList<>();
        answerList.add(a1);
        answerList.add(a2);

        q.setAnswerList(answerList);

        //(cascasde=CascadeType.ALL):- types of cascade: Detach,Merge,Persist,Refresh,Remove.


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction tx=session.beginTransaction();

        session.persist(q);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
