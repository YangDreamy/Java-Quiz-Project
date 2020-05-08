package fr.epita.quiz.datamodel;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Exam")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//自增加根据底层数据库自动选择（默认）
	private Long id;
	
	@Column(name="E_TITLE")
	private String e_title;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Exam_Question")
	private List<Question> questions;
	public Long getId() {
		return id;
	}
	public Exam() {}
	public Exam(String e_title)
	{
		this.e_title= e_title;
		
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", e_title=" + e_title + ", questions=" + questions + "]";
	}
	

}
