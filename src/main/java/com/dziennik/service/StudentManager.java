package com.dziennik.service;
import java.util.Date;
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
    
    public Student get(Long id) {
        return em.find(Student.class, id);
    }
    
	public void addStudent(Student student) {
		student.setId(null);
		student.setCreatedAt(new Date());
		em.persist(student);
	}
	public void updateStudent(Long id, String name, String surname, String sex, long pesel){
		Student student = em.find(Student.class, id);
		student.setName(name);
		student.setSurname(surname);
		student.setSex(sex);
		student.setPesel(pesel);

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
