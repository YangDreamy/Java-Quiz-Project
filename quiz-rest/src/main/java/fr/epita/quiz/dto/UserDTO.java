package fr.epita.quiz.dto;

import java.util.List;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.User;

public class UserDTO {

	
	private String loginname;
	private List<MCQAnswer> mcqanswer;
	public List<MCQAnswer> getMcqanswer() {
		return mcqanswer;
	}
	public void setMcqanswer(List<MCQAnswer> mcqanswer) {
		this.mcqanswer = mcqanswer;
	}
	public UserDTO(){
		
	}
	public UserDTO(User entity){
		this.setLoginname(entity.getLoginname());
		
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
}
