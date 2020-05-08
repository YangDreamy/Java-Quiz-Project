package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.User;

public class UserDAO extends GenericDAO<User, String> {

	@Override
	public String getQuery() {
		return "from User where loginname= :loginname ";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, User criteria) {
		parameters.put("loginname",criteria.getLoginname());
		
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	public String getAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareSearch(User criteria, QueryHolder<User> holder) {
		// TODO Auto-generated method stub
		
	}


	

}
