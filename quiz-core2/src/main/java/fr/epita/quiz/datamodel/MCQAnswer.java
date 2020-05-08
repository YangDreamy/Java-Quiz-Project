package fr.epita.quiz.datamodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MCQAnswer")
public class MCQAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//自增加
	private Long id;
	
	@Column(name="m_answer")
	private boolean m_answer;
	
//	@ManyToOne
	@OneToOne
	@JoinColumn(name = "MCQ_Q_A")
	private MCQChoice mcqchoice;
	
	
	@OneToMany(cascade = CascadeType.ALL)//级联操作，相当于外键的增加，删除，等操作
	List<User> user;
	public MCQAnswer() {}
	public MCQAnswer(boolean m_answer) {
		this.m_answer = m_answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isM_answer() {
		return m_answer;
	}

	public void setM_answer(boolean m_answer) {
		this.m_answer = m_answer;
	}

	public MCQChoice getMcqchoice() {
		return mcqchoice;
	}

	public void setMcqchoice(MCQChoice mcqchoice) {
		this.mcqchoice = mcqchoice;
	}

	@Override
	public String toString() {
		return "MCQAnswer [id=" + id + ", m_answer=" + m_answer + ", mcqchoice=" + mcqchoice + "]";
	}
	

	
	

}
