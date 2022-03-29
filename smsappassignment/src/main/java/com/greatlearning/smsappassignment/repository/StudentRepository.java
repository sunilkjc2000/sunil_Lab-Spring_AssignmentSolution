package com.greatlearning.smsappassignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.smsappassignment.model.StudentEntity;


public interface StudentRepository extends JpaRepository < StudentEntity, Long >  {

	//    List < StudentEntity > findByStudentName(String name);

}
