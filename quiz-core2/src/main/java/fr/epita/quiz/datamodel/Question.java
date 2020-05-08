package fr.epita.quiz.datamodel;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//自增加根据底层数据库自动选择（默认）
	private Long id;
	
	@Column(name="Q_TITLE")
	private String title;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Answer> answers;
	
	@OneToMany(cascade = CascadeType.ALL)//级联操作，相当于外键的增加，删除，等操作
	List<MCQChoice> mcqchoice;
	
	@OneToMany(cascade = CascadeType.ALL)//级联操作，相当于外键的增加，删除，等操作
	List<Exam> exam;
	

	
	public Question() {
	}
	
	public Question(String title)
	{
		this.title= title;
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public  String toString() {
		return "id="+id+", title +"+ title;
	}
  
	
}
