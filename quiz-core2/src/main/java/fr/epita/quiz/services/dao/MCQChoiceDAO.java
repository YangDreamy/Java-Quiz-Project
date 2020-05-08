package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class MCQChoiceDAO extends GenericDAO<MCQChoice,Long>{

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Class<MCQChoice> getEntityClass() {
		return MCQChoice.class;
	}


	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return "from MCQChoice where choice = :choice";
	}

	
	@Override
	public String getAllQuery() {
		return "from MCQChoice";
	}
	


	@Override
	public void prepareSearch(MCQChoice criteria, QueryHolder<MCQChoice> holder) {
		holder.setQueryString("from MCQChoice as mcqchoice where mcqchoice.question = :question");
		holder.setClassName(MCQChoice.class);
		holder.putParameter("question", criteria.getQuestion());
		
	}


	@Override
	public void setParameters(Map<String, Object> parameters, MCQChoice criteria) {
		parameters.put("choice", criteria.getChoice());
		
	}

	public void setParameters_2(Map<String, Object> parameters, MCQChoice criteria) {
		parameters.put("question", criteria.getQuestion());
		
	}

	public List<MCQChoice> searchByQuestionId(MCQChoice mcqchoice) {
		Query searchQuery = em.createQuery("from MCQChoice where question = :question");
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters_2(parameters, mcqchoice);
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();
	}
}
