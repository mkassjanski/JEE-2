package com.dziennik.service;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dziennik.domain.Student;

@Stateless
public class StudentManager {
    @PersistenceContext
    EntityManager em;
    
	public void addStudent(Student student) {
		student.setId(null);
		em.persist(student);
	}
	public void updateStudent(Student student){
		student = em.find(Student.class, student.getId());
		em.merge(student);
	}
	
	public void deleteStudent(Student student) {
		student = em.find(Student.class, student.getId());
		em.remove(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		return em.createNamedQuery("student.all").getResultList();
	}
}
