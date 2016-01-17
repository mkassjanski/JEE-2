package com.dziennik.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;

import com.dziennik.service.ProfessorManager;
import com.dziennik.domain.Professor;
@Stateless
@Path("/professor")
public class ProfessorResource {
    @EJB
    ProfessorManager pm;
    
	@GET
	@Path("/show")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getAllProfessor() {
    return pm.getAllProfessor();
	}
	
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor add(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("title") String title) {

    	Professor professor = new Professor();

    	professor.setName(name);
    	professor.setSurname(surname);
    	professor.setTitle(title);

    	//pm.add(professor);

        return professor;
    }
}
