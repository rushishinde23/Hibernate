package oneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "q_id")
    private int questionID;
    private String question;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question(int questionID, String question, Answer answer) {
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
        super();
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
