package fr.epita.quiz.dto;

import java.util.List;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;

public class ExamDTO {
	private String e_title;
	private List<Question> questions;
	public ExamDTO() {}
	
	public  ExamDTO(Exam entity) {
		this.e_title = entity.getE_title();
		  this.questions = entity.getQuestions();
		 }
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	public List<Question> getQuestion() {
		return questions;
	}
	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
	

}
