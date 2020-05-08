package fr.epita.quiz.datamodel;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MCQChoice")
public class MCQChoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//×ÔÔö¼Ó
	private Long id;
	
	@Column(name="Choice")
	private String choice;
	
	@Column(name="vaild")
	private boolean vaild;
	
	public MCQChoice() {
		
	}
	

	public MCQChoice(String choice)
	{
		this.choice= choice;
		
	}
	
	@ManyToOne
	@JoinColumn(name = "qestion_id")
	private Question question;
	public Question getQuestion() {
		return question;
	}
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "MCQQ_A")
//	List <MCQChoice> mcqchoice;

	public void setQuestion(Question question) {
		this.question = question;
	}	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	


	@Override
	public  String toString() {
		return "id="+id+", choice="+choice +"vaild"+vaild+" question "+question.toString();
	}
  
	
	

}
