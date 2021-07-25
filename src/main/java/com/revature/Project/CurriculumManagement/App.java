package com.revature.Project.CurriculumManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.Project.CurriculumManagement.model.Classes;
import com.revature.Project.CurriculumManagement.model.Student;
import com.revature.Project.CurriculumManagement.model.Subject;
import com.revature.Project.CurriculumManagement.model.Teacher;
import com.revature.Project.CurriculumManagement.model.Topics;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * System.out.println("Enter the number of students:"); Integer noOfStudents =
		 * Integer.parseInt(br.readLine()); List<Student> studentList = new
		 * ArrayList<Student>(); Student student = new Student();
		 * System.out.println("Enter the student details:"); for (Integer i = 0; i <
		 * noOfStudents; i++) { Integer studentId = Integer.parseInt(br.readLine());
		 * String studentName = br.readLine(); String studentDateOfBirth =
		 * br.readLine(); String studentStandard = br.readLine(); String studentAddress
		 * = br.readLine(); student.setRollNo(studentId); student.setName(studentName);
		 * student.setDateOfBirth(studentDateOfBirth);
		 * student.setStandard(studentStandard); student.setAddress(studentAddress);
		 * studentList.add(new Student(student.getRollNo(), student.getName(),
		 * student.getDateOfBirth(), student.getStandard(), student.getAddress())); }
		 * Iterator<Student> studentIterator = studentList.iterator(); while
		 * (studentIterator.hasNext()) { System.out.println(studentIterator.next()); }
		 * List<Classes> classList = new ArrayList<Classes>(); Classes classes = new
		 * Classes(); System.out.println("Enter the class details:"); Integer classId =
		 * Integer.parseInt(br.readLine()); String className = br.readLine();
		 * classes.setClassId(classId); classes.setClassName(className);
		 * classList.add(new Classes(classes.getClassId(), classes.getClassName()));
		 * Iterator<Classes> classIterator = classList.iterator(); while
		 * (classIterator.hasNext()) { System.out.println(classIterator.next()); }
		 * List<Subject> subjectList = new ArrayList<Subject>(); Subject subject = new
		 * Subject(); System.out.println("Enter the subject details:"); Integer
		 * subjectId = Integer.parseInt(br.readLine()); String subjectName =
		 * br.readLine(); subject.setSubId(subjectId); subject.setSubName(subjectName);
		 * subjectList.add(new Subject(subject.getSubId(), subject.getSubName()));
		 * Iterator<Subject> subjectIterator = subjectList.iterator(); while
		 * (subjectIterator.hasNext()) { System.out.println(subjectIterator.next()); }
		 * List<Teacher> teacherList=new ArrayList<Teacher>(); Teacher teacher=new
		 * Teacher(); System.out.println("Enter the teacher details:"); Integer
		 * teacherId=Integer.parseInt(br.readLine()); String teacherName=br.readLine();
		 * String teacherDateOfBirth=br.readLine(); String teacherAddress=br.readLine();
		 * String teacherQualification=br.readLine(); String
		 * teacherDesignation=br.readLine(); String teacherClass=br.readLine();
		 * teacher.setId(teacherId); teacher.setName(teacherName);
		 * teacher.setDateOfBirth(teacherDateOfBirth);
		 * teacher.setAddress(teacherAddress);
		 * teacher.setQualification(teacherQualification);
		 * teacher.setDesignation(teacherDesignation);
		 * teacher.setClassTeacher(teacherClass); teacherList.add(new
		 * Teacher(teacher.getId(),teacher.getName(),teacher.getDateOfBirth(),teacher.
		 * getAddress(),teacher.getQualification(),teacher.getDesignation(),teacher.
		 * getClassTeacher())); Iterator<Teacher>
		 * teacherIterator=teacherList.iterator(); while(teacherIterator.hasNext()) {
		 * System.out.println(teacherIterator.next()); }
		 */
		List<Topics> topicList=new ArrayList<Topics>();
		Topics topics=new Topics();
		System.out.println("Enter the topics details:");
		String topicId=br.readLine();
		String topicName=br.readLine();
		topics.setTopicId(topicId);
		topics.setTopicName(topicName);
		topicList.add(new Topics(topics.getTopicId(),topics.getTopicName()));
		Iterator<Topics> topicIterator=topicList.iterator();
		while(topicIterator.hasNext())
		{
			System.out.println(topicIterator.next());
		}
	}
}
