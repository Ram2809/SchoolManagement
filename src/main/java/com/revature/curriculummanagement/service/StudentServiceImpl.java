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
	List<Student> studentList = new ArrayList<Student>();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public void addStudentDetails(Student student) {
		studentList.add(student);
	}

	public void getStudentDetails(Student student) {
		Iterator<Student> studentIterator = studentList.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}
	public void updateStudentDetails(Student student) throws IOException,StudentNotFoundException
	{
		System.out.println("Enter the id to update:");
		Integer updateStudentId=Integer.parseInt(br.readLine());
		List<Integer> idList=new ArrayList<>();
		int index=0;
		idList=studentList.stream().map(id->student.getRollNo()).collect(Collectors.toList());
		if(!idList.contains(updateStudentId))
		{
			throw new StudentNotFoundException("Student id not found, enter the valid id!");
		}
		else
		{
			index=idList.indexOf(updateStudentId);
		}
		String userStudentName=br.readLine();
		student.setName(userStudentName);
		getStudentDetails(student);
	}
}