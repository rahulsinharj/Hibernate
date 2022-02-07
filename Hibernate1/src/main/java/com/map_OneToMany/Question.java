package com.map_OneToMany;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "ques_id")
	private int questionId;
	
	private String question;
	
	@OneToMany(mappedBy = "question")	// Jo bhi Foreign key column creation ka kaam tha wo "Question" class ke "answers" wale instance se chhinke kewal "Answer" class ke "question" instance	 ke de diya gaya hai.
	private List<Answer> answers;		// Matlab ab, jo bhi join colum banega -> wo banega "Answer" class ke Table ke "question" field me
										// One Qustion can have many Answers.
	
	public Question() {
		super();
	}
	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
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
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}
	
	
	
	
}
