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

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.dto.ExamDTO;
import fr.epita.quiz.dto.MCQAnswerDTO;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.MCQAnswerDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;

@Path("/exam")
public class ExamMCQAnswer {

	@Inject 
	ExamDataService examDS;
	
	@Inject
	MCQChoiceDAO mcqchoicedao;
	
	@Inject
	MCQAnswerDAO mcqanswerdao;
	
	private static final Logger LOGGER = LogManager.getLogger(ExamMCQChoice.class);
	@POST
	@Path("/mcqanswer/create")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(@RequestBody MCQAnswerDTO mcqanswerdto) throws URISyntaxException {
		//create a question
		MCQAnswer mcqanswer = new MCQAnswer();
		mcqanswer.setM_answer(mcqanswerdto.isM_answer());
		mcqanswer.setMcqchoice(mcqanswerdto.getMcqchoice());
		mcqanswerdao.create(mcqanswer);
		System.out.println(mcqanswer.toString());
		return Response.created(new URI("/rest/exam/mcqanswer/"  + String.valueOf(mcqanswer.getId()))).build();
	}
	@GET
	@Path("/mcqanswer/searchAll")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchAllMCQAnswer() {
		//create a question 
		
		MCQAnswer mcqanswer = new MCQAnswer();
		System.out.println("right");
		List<MCQAnswer> searchList = mcqanswerdao.searchAll(new MCQAnswer());
		
		for(MCQAnswer mcqanswerentity: searchList)
			{
				mcqanswer = mcqanswerentity;
				System.out.println(mcqanswer.toString());
			}
		return Response.ok(searchList).build();
	}

	

}
