package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/students")

public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("{id}")
	public Student getStudent(long id) {
		return studentRepository.findById(id).orElse(null);

	}

	@PostMapping
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}

	@PutMapping("{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable long id) {
		studentRepository.save(student);
	}

	@DeleteMapping("{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

}