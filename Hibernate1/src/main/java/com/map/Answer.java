package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@Column(name = "ans_id")
	private int answerId;
	private String answer;
										// Kyuki Question table me already answer ke foreign key hai {Kewal etna hi hota to UniDirectional Mapping reh jata}
										// But now since we have also included Foreign key of Question in this Answer table, to ab isse bhi Question table ka content pata lagaya ja sakta hai, So now it is BiDirectional Mapping.
	@OneToOne(mappedBy = "answer")		// @OneToOne ke karan "Answer table" me ek Foreign Key column ban jayega -> joki "Question table" ka Primary key hoga. 
	private Question question;			// mappedBy = "answer" ke karan ab Answer table me Question ka foreign key nhi banega ;  kewal bas Question table me hi Answer key banega.
	
	
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
