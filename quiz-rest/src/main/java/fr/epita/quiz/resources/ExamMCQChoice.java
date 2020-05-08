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

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.dto.MCQChoiceDTO;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@Path("/exam")
public class ExamMCQChoice {
	
	@Inject 
	ExamDataService examDS;
	
	@Inject
	MCQChoiceDAO dao;
	
	@Inject
	QuestionDAO questiondao;
	
	private static final Logger LOGGER = LogManager.getLogger(ExamMCQChoice.class);
	
	@GET
	@Path("/mcqchoice")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getMCQQuestion(@QueryParam("questionid") Long questionId) {
		//beginning dummy implementation
		
		Question questions = new Question();
		questions = questiondao.getById(questionId);
		System.out.println(questions.toString());
		return Response.ok(questions).build();
	}
	@GET
	@Path("/mcqchoice/searchMCQID")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getMCQID(@QueryParam("choiceid") Long choiceid) {
		//beginning dummy implementation
		MCQChoice mcqchoice = new MCQChoice();
		mcqchoice = dao.getById(choiceid);
		return Response.ok(mcqchoice).build();
	}
	
	@POST
	@Path("/mcqchoice/create")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response createMCQChoice(@RequestBody MCQChoiceDTO mcqchoicedto,@QueryParam("questionid") Long questionId) throws URISyntaxException {
		LOGGER.debug("entering => createMCQChoice() with parameters : {} ", mcqchoicedto);
		//create a question 
		MCQChoice mcqchoice = new MCQChoice();
		Question questions = new Question();
		mcqchoice.setChoice(mcqchoicedto.getChoice());
		mcqchoice.setVaild(mcqchoicedto.isVaild());
		questions = questiondao.getById(questionId);
		mcqchoice.setQuestion(questions);
		System.out.println(mcqchoice.toString());
		LOGGER.info("received creation order for mcqchoice : {}",  mcqchoicedto);
		dao.create(mcqchoice);
		return Response.created(new URI("/rest/exam/mcqchoice/" + String.valueOf(mcqchoice.getId()))).build();
		
	}
	@GET
	@Path("/mcqchoice/searchchoice")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchChoices(@QueryParam("choice") String choice) {
		//create a question 
		MCQChoice mcqchoice = new MCQChoice();
		List<MCQChoice> searchList = dao.search(new MCQChoice(choice));
		for(MCQChoice mcqEntity: searchList)
			{
				mcqchoice  = mcqEntity;
				System.out.println(mcqchoice.toString());
			}
		return Response.ok(searchList).build();
	}
	@GET
	@Path("/mcqchoice/searchAll")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchAllChoice() {
		MCQChoice mcqchoices = new MCQChoice();
		List<MCQChoice> searchList = dao.searchAll(new MCQChoice());
		for(MCQChoice mcqchoiceEntity: searchList)
			{
				mcqchoices = mcqchoiceEntity;
				System.out.println(mcqchoices.toString());
			}
		return Response.ok(searchList).build();
	}
	
	@POST
	@Path("mcqchoice/update")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response updateMCQChoice(@RequestBody MCQChoice mcqchoice) throws URISyntaxException {
		dao.update(mcqchoice);
		System.out.println(mcqchoice.toString());
		return Response.created(new URI("/rest/exam/mcqchoice/" + String.valueOf(mcqchoice.getId()))).build();
	}
	//≤È—Øquestionidœ‘ æchoice
	@POST
	@Path("/mcqchoice/searchbyquestion")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchByQeustionId(@RequestBody Question question) {
		System.out.println(question.toString());
		MCQChoice mcqchoice = new MCQChoice();
		mcqchoice.setQuestion(question);
		List<MCQChoice> resultList = dao.searchByQuestionId(mcqchoice);
		return Response.ok(resultList).build();
	}

//	
}
	
