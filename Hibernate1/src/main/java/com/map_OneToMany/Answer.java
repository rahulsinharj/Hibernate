package com.map_OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
	
@Entity
public class Answer {

	@Id
	@Column(name = "ans_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
//	@JoinColumn(name = "question_foreignKey_id")	// Answer table ke Join column ko agar ye tag lagake rename nhi karege, to automatically "question_ques_id" naam se table ban jayega.
	private Question question;						// We can also add here @JoinColumn(name = "question_foreignKey_id")  for changing this join column name
	
	public Answer() {
		super();
	}
	public Answer(int answerId, String answer, Question question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
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

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}
	
	
	
}
