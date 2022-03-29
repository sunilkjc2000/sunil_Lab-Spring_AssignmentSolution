package com.greatlearning.smsappassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.smsappassignment.model.StudentEntity;
import com.greatlearning.smsappassignment.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	  @Autowired
	    private StudentRepository studentRepository;
       
	//  @Override
	  //  public List < StudentEntity > getStudentsByName(String name) {
	    //    return studentRepository.findByStudentName(name);
	    //}

	    @Override
	    public Optional<StudentEntity> findById(Long id) {
	        return studentRepository.findById(id);
	    }

	    @Override
	    public void save(StudentEntity studentEntity) {
	    	studentRepository.save(studentEntity);
	    }

	    @Override
	    public void addStudent(String firstName, String lastName, String department,String country) {
	    	studentRepository.save(new StudentEntity(firstName, lastName, department, country));
	    }

	    @Override
	    public void deleteById(Long id) {
	        Optional < StudentEntity > student = studentRepository.findById(id);
	        if (student.isPresent()) {
	        	studentRepository.delete(student.get());
	        }
	    }
	    
		@Override
		public List<StudentEntity> findAll() {
			return studentRepository.findAll();
		}

	




			

}
