package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.Question;

public class QuestionDTO {
	private String title;

	public QuestionDTO(){
		
	}
	public QuestionDTO(Question entity){
		this.title = entity.getTitle();
		
	}
	public String getTitle() {
		return title;
	}

	public void setContent(String title) {
		this.title = title;
	}


}
