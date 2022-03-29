package com.greatlearning.smsappassignment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {


	    public StudentEntity(String firstName2, String lastName2, String department2, String country2) {
		// TODO Auto-generated constructor stub
	    	super();
	        this.firstName = firstName2;
	        this.lastName = lastName2;
	        this.department = department2;
	        this.country = country2;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    private String firstName;

	    private String lastName;

	    private String department;
	    
	    private String country;
	
}
