package com.dziennik.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dziennik.domain.Professor;


@Stateless
public class ProfessorManager {
	
	@PersistenceContext
	EntityManager em;
	public Professor get(Long id){
		return em.find(Professor.class, id);
	}
	
	public void add(Professor professor) {
		professor.setId(null);
		em.persist(professor);
       // em.flush();
	}
	
	public List<Professor> getAllProfessor() {
		return em.createNamedQuery("professor.all").getResultList();
}
}
