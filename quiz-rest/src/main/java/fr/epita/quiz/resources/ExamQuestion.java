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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.QuestionDAO;

@Path("/exam")
public class ExamQuestion {
	@Inject 
	ExamDataService examDS;
	
	@Inject
	QuestionDAO dao;
	private static final Logger LOGGER = LogManager.getLogger(ExamQuestion.class);
	

	@POST
	@Path("/question")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		LOGGER.debug("entering => createQuestion() with parameters : {} ", question);
		//create a question 
		dao.create(question);
		LOGGER.info("received creation order for question : {}",  question);
		return Response.created(new URI("/rest/exam/quetion/"  + String.valueOf(question.getId()))).build();
	}
	
	@GET
	@Path("/question")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchQuestions(@QueryParam("qTitle") String title) {
		//create a question 
		Question questions = new Question();
		List<Question> searchList = dao.search(new Question(title));
		for(Question questionEntity: searchList)
			{
				questions = questionEntity;
				System.out.println(questions.getTitle());
				System.out.println(questions.getId());
			}
		return Response.ok(searchList).build();
	}
	
	@GET
	@Path("/question/searchAll")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchAllQuestions() {
		//create a question 
		Question questions = new Question();
		List<Question> searchList = dao.searchAll(new Question());
		for(Question questionEntity: searchList)
			{
				questions = questionEntity;
				System.out.println(questions.getTitle());
				System.out.println(questions.getId());
			}
		return Response.ok(searchList).build();
	}
	
	@POST
	@Path("question/update")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response updateMCQChoice(@RequestBody Question question) throws URISyntaxException {
		System.out.println(question.toString());
		dao.update(question);
		System.out.println(question.toString());
		return Response.created(new URI("/rest/exam/question/" + String.valueOf(question.getId()))).build();
	}
	
}
