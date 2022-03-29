package com.greatlearning.smsappassignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.smsappassignment.SaveFileDialog;
import com.greatlearning.smsappassignment.model.StudentEntity;
import com.greatlearning.smsappassignment.service.StudentService;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
@Controller
@RequestMapping("/student")
public class StudentController {
	

		@Autowired
		private StudentService studentService;

		// add mapping for "/list"

		@RequestMapping("/list")
		public String listBooks(Model theModel) {

			System.out.println("request recieved");
			// get Books from db
			List<StudentEntity> theStudents = studentService.findAll();
			

			// add to the spring model
			theModel.addAttribute("Students", theStudents);

			return "list-Students";
		}

		@RequestMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {

			// create model attribute to bind form data
			StudentEntity theStudent = new StudentEntity();

			theModel.addAttribute("Student", theStudent);

			return "student-form";
		}

		@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("studentId") Long theId,
				Model theModel) {

			// get the Book from the service
			StudentEntity theStudent = studentService.findById(theId).get();


			// set Book as a model attribute to pre-populate the form
			theModel.addAttribute("Student", theStudent);

			// send over to our form
			return "student-form";			
		}


		@PostMapping("/save")
		public String saveBook(@RequestParam("id") Long id,
				@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("department") String department,@RequestParam("country") String country) {

			System.out.println(id);
			StudentEntity theStudent;
			if(id!=0)
			{
				theStudent=studentService.findById(id).get();
				theStudent.setFirstName(firstName);
				theStudent.setLastName(lastName);
				theStudent.setDepartment(department);
				theStudent.setCountry(country);
			}
			else
				theStudent=new StudentEntity(firstName, lastName, department,country);
			// save the Book
			studentService.save(theStudent);


			// use a redirect to prevent duplicate submissions
			return "redirect:/student/list";

		}


		@RequestMapping("/delete")
		public String delete(@RequestParam("studentId") Long theId) {

			// delete the Book
			String UserName;
			
			studentService.deleteById(theId);
			        
			

			// redirect to /Books/list
			return "redirect:/student/list";

		}
		
		@RequestMapping("/printToFile")
		public String printToFile() throws FileNotFoundException {

			SaveFileDialog saveToFile = new SaveFileDialog();
			File file = saveToFile.createWindow();
			List<StudentEntity> theStudents = studentService.findAll();
			
			if(file != null) {
			    PrintWriter pw = new PrintWriter(new FileOutputStream(file.getAbsoluteFile()));
			
			    for(StudentEntity student : theStudents)
			    {
				    pw.println(student);
			    }
			    pw.close();
			}
		
			
	//		FileUtils.
			// redirect to /Books/list
			return "redirect:/student/list";

		}

}
