package com.greatlearning.smsappassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.greatlearning.smsappassignment.model.StudentEntity;

public interface StudentService {
	
		public List<StudentEntity> findAll();

		public Optional<StudentEntity> findById(Long theId);

		public void save(StudentEntity thestudent);

		public void deleteById(Long theId);;
		
		// public List < StudentEntity > getStudentsByName(String name);

		void addStudent(String firstName, String lastName, String department, String country);

}
