package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.dto.AnswerDTO;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.services.dao.UserDAO;

@Path("/exam")
public class ExamAnswer {
	
	@Inject 
	ExamDataService examDS;
	
	@Inject
	AnswerDAO answerDao;
	
	@Inject
	QuestionDAO questiondao;
	
	@Inject
	UserDAO userdao;
	
	
//	@POST
//	@Path("/Q_Answer/create")
//	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
//	public Response createMCQChoice(@RequestBody AnswerDTO answerdto,@QueryParam("questionid") Long questionId,@QueryParam("name") String loginName) throws URISyntaxException {
//		//create a question 
//		Answer answer = new Answer();
//		Question questions = new Question();
//		User users = new User();
//		answer.setContent(answerdto.getContent());
//		List<User> searchUserList = userdao.search(new User(loginName));
//		for(User userEntity: searchUserList)
//		{
//			users = userEntity;
//			answer.setUser(users);
//		}
//		questions = questiondao.getById(questionId);
//
//		answer.setQuestion(questions);
//		
//		System.out.println(answer.toString());
//		answerDao.create(answer);
//		return Response.created(new URI("/rest/exam/Q_Answer/" + String.valueOf(answer.getId()))).build();
//		
//	}
//	
//	@GET
//	@Path("/Q_Answer/search")
//	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
//	public Response searchChoices(@QueryParam("content") String content) {
//		//create a question 
//		Answer answer = new Answer();
//		List<Answer> searchList = answerDao.search(new Answer(content));
//		for(Answer mcqEntity: searchList)
//			{
//				answer  = mcqEntity;
//				System.out.println(answer.toString());
//			}
//		return Response.ok(searchList).build();
//	}
//	
	

}
