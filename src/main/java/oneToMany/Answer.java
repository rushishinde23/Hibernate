package oneToMany;

import jakarta.persistence.*;


@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "a_id")
   private int answerID;

    private String answer;

    @ManyToOne
    private Question question;

    public Answer() {
        super();
    }

    public Answer(int answerID, String answer, Question question) {
        this.answerID = answerID;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", answer='" + answer + '\'' +
                '}';
    }
}