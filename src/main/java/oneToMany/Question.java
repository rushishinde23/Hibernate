package oneToMany;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "q_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public Question(int questionId, String question, List<Answer> answerList) {
        this.questionId = questionId;
        this.question = question;
        this.answerList = answerList;
    }

    public Question() {
        super();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
