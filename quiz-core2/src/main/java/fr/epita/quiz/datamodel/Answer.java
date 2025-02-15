package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="A_CONTENT")
	private String content;
	
//	@ManyToOne
//	@JoinColumn(name="A_QUESTION")
//	private Question question;
//	@ManyToOne
//	@JoinColumn(name="A_USER")
//	private User user;
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Answer() {

	}
	public Answer(String content)
	{
		this.content= content;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
//
//	@Override
//	public  String toString() {
//		return "id="+id+", content="+content +" question "+question.toString()+" + "+user.toString();
//	}
	
	
	
	
	
}
