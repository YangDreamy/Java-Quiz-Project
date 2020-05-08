package fr.epita.quiz.services.dao;

import java.util.Map;



import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.MCQChoice;

public class AnswerDAO extends GenericDAO<Answer, Long>{

	@Override
	public String getQuery() {
		return "from Answer where content = :content";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Answer criteria) {
		parameters.put("content", criteria.getContent());
		
	}

	@Override
	public Class<Answer> getEntityClass() {
		// TODO Auto-generated method stub
		return Answer.class;
	}

	@Override
	public String getAllQuery() {
		// TODO Auto-generated method stub
		return "from Answer";
	}

	@Override
	public void prepareSearch(Answer criteria, QueryHolder<Answer> holder) {
		// TODO Auto-generated method stub
		
	}



	

}
