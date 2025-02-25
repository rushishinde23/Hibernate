package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMappingDemo {
    public static void main(String[] args) {

//        Question question1=new Question();
//        question1.setQuestionId(101);
//        question1.setQuestion("What is JAVA?");
//
//        Answer answer1=new Answer();
//        answer1.setAnswerID(10101);
//        answer1.setAnswer("JAVA is platform independent programming language");
//        answer1.setQuestion(question1);
//
//        Answer answer2=new Answer();
//        answer2.setAnswerID(10102);
//        answer2.setAnswer("It is object oriented language");
//        answer2.setQuestion(question1);
//
//        Answer answer3=new Answer();
//        answer3.setAnswerID(10103);
//        answer3.setAnswer("JAVA supports is used for creating web applications");
//        answer3.setQuestion(question1);
//
//        List<Answer> answerList=new ArrayList<>();
//        answerList.add(answer1);
//        answerList.add(answer2);
//        answerList.add(answer3);
//
//        question1.setAnswerList(answerList);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
     //  Transaction tx=session.beginTransaction();

//        session.persist(question1);
//          session.persist(answer1);
//          session.persist(answer2);
//          session.persist(answer3);

        Question question=session.get(Question.class,101);
        System.out.println(question.getQuestion());
        //System.out.println(question.getAnswerList());
        for(Answer a: question.getAnswerList()){
            System.out.println(a.getAnswer());
        }

       // tx.commit();
        session.close();
        sessionFactory.close();
    }
}
