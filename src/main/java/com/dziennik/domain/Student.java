package com.dziennik.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "student.all", query = "select s from Student s order by s.id")
})
public class Student implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
	 
	 private String name;
	 private String surname;
	 private String sex;
	 private long pesel;
	 

	 @Temporal(TemporalType.DATE)
	 private Date createdAt;
	 
     public Student() {
        super();
     }
 
	 
	 public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public long getPesel() {
		return pesel;
	}


	public void setPesel(long pesel) {
		this.pesel = pesel;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


}
