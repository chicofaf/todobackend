package service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import dao.FactoryDao;
import model.Todo;

@Path("/todo")
public class TodoService {

	@GET
	@Path("/")
	@Produces("application/json")
	public ArrayList<Todo> retrieve() {
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		todoList = FactoryDao.getTododao().retrieve();
		return todoList;
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(Todo todo) {
		FactoryDao.getTododao().create(todo);
		return Response.ok().entity(new ServiceResponse(201, "Tarefa Cadastrada")).build();
	}

	@DELETE
	@Path("/delete")
	@Produces("application/json")
	public Response delete(Todo todo) {
		FactoryDao.getTododao().delete(todo.getId());
		return Response.ok().entity(new ServiceResponse(200, "Tarefa Excluída")).build();
	}

	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Todo todo) {
		FactoryDao.getTododao().update(todo);
		return Response.ok().entity(new ServiceResponse(200, "Tarefa Atualizada")).build();
	}


}
