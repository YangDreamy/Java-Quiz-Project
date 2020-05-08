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
	@GeneratedValue(strategy = GenerationType.AUTO)//�����Ӹ��ݵײ����ݿ��Զ�ѡ��Ĭ�ϣ�
	private Long id;
	
	@Column(name="Q_TITLE")
	private String title;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Answer> answers;
	
	@OneToMany(cascade = CascadeType.ALL)//�����������൱����������ӣ�ɾ�����Ȳ���
	List<MCQChoice> mcqchoice;
	
	@OneToMany(cascade = CascadeType.ALL)//�����������൱����������ӣ�ɾ�����Ȳ���
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
