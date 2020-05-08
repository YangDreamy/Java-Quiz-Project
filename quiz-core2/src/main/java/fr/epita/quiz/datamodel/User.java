package fr.epita.quiz.datamodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uid;
	
	@Column(name="U_LOGIN")
	private String loginname;
	
//	@OneToMany
//	List<Answer> answers;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "User_MCQAnswer")
	private List<MCQAnswer> mcqanswer;

	public List<MCQAnswer> getMcqanswer() {
		return mcqanswer;
	}
	public void setMcqanswer(List<MCQAnswer> mcqanswer) {
		this.mcqanswer = mcqanswer;
	}
//	public List<Answer> getAnswers() {
//		return answers;
//	}
//	public void setAnswers(List<Answer> answers) {
//		this.answers = answers;
//	}
	public User() {};
	public User(String loginname)
	{
		this.loginname= loginname;
		
	}


	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", loginname=" + loginname + ", mcqanswer=" + mcqanswer
				+ "]";
	}
	
	
	
}
