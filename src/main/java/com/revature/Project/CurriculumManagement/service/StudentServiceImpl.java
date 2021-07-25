package com.revature.Project.CurriculumManagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.Project.CurriculumManagement.model.Student;

public class StudentServiceImpl implements StudentService {
	List<Student> studentList = new ArrayList<Student>();

	public void addStudentDetails(Student student) {
		studentList.add(student);
	}

	public void getStudentDetails(Student student) {
		Iterator<Student> studentIterator = studentList.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}
}
