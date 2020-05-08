package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;

public class AnswerDTO {
	
	//��Ϊ֮ǰ��exam ������ǰ��entity����
	
	//private transient Answer answer; is very close with answer entity
	
	private String content;
	private Question question;
	private User user;
	public Question getQuestion() {
		return question;
	}
	public User gerUser()
	{
		return user;
	}

	public AnswerDTO(){
		
	}

	public AnswerDTO(Answer entity) {
		  this.content= entity.getContent();
//		  this.question = entity.getQuestion();
		 }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	

	
	
}
