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
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.dto.UserDTO;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.UserDAO;


@Path("/exam")
public class ExamUser {
	
	@Inject 
	ExamDataService examDS;
	
	@Inject
	UserDAO userdao;
	
	@POST
	@Path("/user")
	@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(@RequestBody UserDTO userdto) throws URISyntaxException {
		//create a question
		User user = new User();
		user.setLoginname(userdto.getLoginname());
		userdao.create(user);
		System.out.println(user.toString());
		return Response.created(new URI("/rest/exam/user/"  + String.valueOf(user.getUid()))).build();
	}
	@GET
	@Path("/user/search")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response searchQuestions(@QueryParam("name") String loginName) {
		User users = new User();		
		List<User> searchUserList = userdao.search(new User(loginName));
        System.out.println(searchUserList);
		for(User userEntity: searchUserList)
			{
				users = userEntity;
			}
		return Response.ok(searchUserList).build();
	}
	
	@POST
	@Path("user/update")
	@Produces(value = MediaType.APPLICATION_JSON_VALUE)
	public Response updateUser(@RequestBody User user) throws URISyntaxException {
		userdao.update(user);
		System.out.println(user.toString());
		return Response.created(new URI("/rest/exam/examtest/" + String.valueOf(user.getUid()))).build();
	}
}
