package com.revature.curriculummanagement.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public class StudentServiceImpl implements StudentService {
	static List<Student> studentList = new ArrayList<Student>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addStudentDetails(Student student) {
		studentList.add(new Student(student.getRollNo(), student.getName(), student.getDateOfBirth(),
				student.getStandard(), student.getAddress()));
	}

	public void getStudentDetails(Student student) {
		Iterator<Student> studentIterator = studentList.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}

	public void updateStudentDetails(Student student) throws NumberFormatException, IOException {
		System.out.println("Enter the student id:");
		Integer updateId = Integer.parseInt(br.readLine());
		System.out.println("Enter the name:");
		String updateName = br.readLine();
		for (Student students : studentList) {
			if (students.getRollNo().equals(updateId)) {
				students.setName(updateName);
				break;
			}
		}
	}

	public void deleteStudentDetails(Student student) throws NumberFormatException, IOException {
		System.out.println("Enter the student id:");
		Integer deleteId = Integer.parseInt(br.readLine());
		Iterator<Student> studentIterator = studentList.iterator();
		while (studentIterator.hasNext()) {
			if (studentIterator.next().getRollNo().equals(deleteId)) {
				studentIterator.remove();
				break;
			}
		}
	}
}