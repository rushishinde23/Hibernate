package oneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "a_id")
    private int answerId;
    private String answer;

    @OneToOne
    @JoinColumn(name = "q_id")
    private Question question;

    public Answer(int answerId, String answer, Question question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public Answer() {
        super();
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
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
}
