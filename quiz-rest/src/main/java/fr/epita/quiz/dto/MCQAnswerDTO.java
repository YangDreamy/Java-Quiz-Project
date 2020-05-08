package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.MCQChoice;

public class MCQAnswerDTO {
	private boolean m_answer;
	private MCQChoice mcqchoice;
	
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

	public MCQAnswerDTO () {
		
	}

	public MCQAnswerDTO(MCQAnswer entity) {
		  this.m_answer = entity.isM_answer();
		  this.mcqchoice = entity.getMcqchoice();
		 }
}
