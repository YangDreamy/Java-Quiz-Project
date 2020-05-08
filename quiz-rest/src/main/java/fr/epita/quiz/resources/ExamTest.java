package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
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

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.dto.ExamDTO;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@Path("/exam")
public class ExamTest {
	
	@Inject
	QuestionDAO questiondao;
	
	
	@Inject
	ExamDAO examdao;
	
	@Inject
	MCQChoiceDAO mcqchoicedao;
	

	@POST
	@Path("/examtest")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(@RequestBody ExamDTO examdto) throws URISyntaxException {
		//create a question
		Exam exam = new Exam();
		exam.setE_title(examdto.getE_title());
		examdao.create(exam);
		System.out.println(exam.toString());
		return Response.created(new URI("/rest/exam/examtest/"  + String.valueOf(exam.getId()))).build();
	}
	
	@GET
	@Path("/examtest/searchAll")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchAllExama() {
		//create a question 
		Exam exam = new Exam();
		List<Exam> searchList = examdao.searchAll(new Exam());
		for(Exam examEntity: searchList)
			{
				exam = examEntity;
				System.out.println(exam.getE_title());
			}
		return Response.ok(searchList).build();
	}
	@GET
	@Path("/examtest")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getExambyID(@QueryParam("examid") Long examid) {
		//beginning dummy implementation
		Exam exam = new Exam();
		exam = examdao.getById(examid);
		System.out.println(exam.toString());
		return Response.ok(exam).build();
	}
	@POST
	@Path("examtest/update")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response updateMCQChoice(@RequestBody Exam exam) throws URISyntaxException {
		examdao.update(exam);
		System.out.println(exam.toString());
		return Response.created(new URI("/rest/exam/examtest/" + String.valueOf(exam.getId()))).build();
	}
	@GET
	@Path("/examtest/searchTitle")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getchoicebyExamTitle(@QueryParam("e_title") String e_title) {
		//beginning dummy implementation
		Exam examSearchBytitle = new Exam();
		List<Exam> searchList = examdao.search(new Exam(e_title));
		List<MCQChoice> resultList = new ArrayList<MCQChoice>(); 
		for(Exam examEntity: searchList)
			{
				examSearchBytitle = examEntity; 
				List<Question> questions = examSearchBytitle.getQuestions();
				Question E_question = new Question();
				MCQChoice mcqcchoices = new MCQChoice();
				for(Question questionentity : questions)
				{
					E_question = questiondao.getById(questionentity.getId());
					mcqcchoices.setQuestion(E_question);
					resultList = mcqchoicedao.searchByQuestionId(mcqcchoices);
				}
			}
		for(MCQChoice mcq : resultList) {
			System.out.println(mcq.toString());
		}
		return Response.ok(resultList).build();
	}
	@GET
	@Path("/examtest/searchExamQueston")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
		public Response getExambyTitle(@QueryParam("e_title") String e_title) {
		//beginning dummy implementation
		Exam examListbyTitle = new Exam();
		List<Exam> searchList = examdao.search(new Exam(e_title));
		for(Exam Examentity : searchList)
		{
			examListbyTitle = Examentity;
			System.out.println(examListbyTitle.toString());
		}
		return Response.ok(searchList).build();
	}
	
}
