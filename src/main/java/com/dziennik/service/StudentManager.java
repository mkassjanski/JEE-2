package com.dziennik.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dziennik.domain.*;

@Stateless
public class StudentManager {
    @PersistenceContext
    EntityManager em;
    
    public Student get(Long id) {
        return em.find(Student.class, id);
    }
    
    public Comment getC(Long id) {
        return em.find(Comment.class, id);
    }
    
	public void add(Student student) {
		student.setId(null);
		student.setCreatedAt(new Date());
		em.persist(student);
	}
	public void update(Long id, String name, String surname, String sex, long pesel){
		Student student = em.find(Student.class, id);
		student.setName(name);
		student.setSurname(surname);
		student.setSex(sex);
		student.setPesel(pesel);

        em.merge(student);
	}
	
	
	public void delete(Long id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		return em.createNamedQuery("student.all").getResultList();
	}
	public List<Student> getStudents(int offset, int limit){
        //noinspection unchecked
        return em.createNamedQuery("student.all").
                setFirstResult(offset).
                setMaxResults(limit).
                getResultList();
    }
	
	public Long getCount() {
        return (Long) em.createQuery("select count(s) from Student s").getSingleResult();
    }

    public void addComment(Student student, Comment comment) {
        List<Comment> comments = student.getComments();
        comments.add(comment);

        student.setComments(comments);

        em.merge(student);
    }
    
    public void updateComment(Long id, String type, String message, String author){
    	Comment comment = em.find(Comment.class, id);
    	comment.setType(type);
    	comment.setMessage(message);
    	comment.setAuthor(author);

        em.merge(comment);
	}
    
	public void deleteComment(Long idC, Long idS) {
		Comment comment = em.find(Comment.class, idC);
		Student student = em.find(Student.class, idS);
		List<Comment> comments = student.getComments();
		comments.remove(comment);
		student.setComments(comments);
		em.merge(student);
	}
    
}
