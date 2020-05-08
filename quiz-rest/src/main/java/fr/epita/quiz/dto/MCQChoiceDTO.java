package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class MCQChoiceDTO {
	
	private String choice;
	private boolean vaild;
	private Question question;
	public MCQChoiceDTO(){
		
	}
//	public MCQChoiceDTO(MCQChoice entity){
//		this.choice = entity.getChoice();
//		
	public Question getQuestion() {
	return question;
}

	public MCQChoiceDTO(MCQChoice entity) {
		  this.choice = entity.getChoice();
		  this.vaild = entity.isVaild();
		  this.question = entity.getQuestion();
		 }
public void setQuestion(Question question) {
	this.question = question;
}	


	public String getChoice() {
		return choice;
	}


	public void setChoice(String choice) {
		this.choice = choice;
	}


	public boolean isVaild() {
		return vaild;
	}


	public void setVaild(boolean vaild) {
		this.vaild = vaild;
	}

}
