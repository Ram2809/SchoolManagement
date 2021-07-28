package com.revature.curriculummanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.model.Teacher;
import com.revature.curriculummanagement.model.Topics;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Classes> classList = new ArrayList<Classes>();
		Classes classes = new Classes();
		System.out.println("Enter the class details:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		String className = bufferedReader.readLine();
		classes.setClassId(classId);
		classes.setClassName(className);
		classList.add(new Classes(classes.getClassId(), classes.getClassName()));
		Iterator<Classes> classIterator = classList.iterator();
		while (classIterator.hasNext()) {
			System.out.println(classIterator.next());
		}
		List<Subject> subjectList = new ArrayList<Subject>();
		Subject subject = new Subject();
		System.out.println("Enter the subject details:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		String subjectName = bufferedReader.readLine();
		subject.setSubId(subjectId);
		subject.setSubName(subjectName);
		subjectList.add(new Subject(subject.getSubId(), subject.getSubName()));
		Iterator<Subject> subjectIterator = subjectList.iterator();
		while (subjectIterator.hasNext()) {
			System.out.println(subjectIterator.next());
		}
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher = new Teacher();
		System.out.println("Enter the teacher details:");
		Integer teacherId = Integer.parseInt(bufferedReader.readLine());
		String teacherName = bufferedReader.readLine();
		String teacherDateOfBirth = bufferedReader.readLine();
		String teacherAddress = bufferedReader.readLine();
		String teacherQualification = bufferedReader.readLine();
		String teacherDesignation = bufferedReader.readLine();
		String teacherClass = bufferedReader.readLine();
		teacher.setId(teacherId);
		teacher.setName(teacherName);
		teacher.setDateOfBirth(teacherDateOfBirth);
		teacher.setAddress(teacherAddress);
		teacher.setQualification(teacherQualification);
		teacher.setDesignation(teacherDesignation);
		teacher.setClassTeacher(teacherClass);
		teacherList.add(new Teacher(teacher.getId(), teacher.getName(), teacher.getDateOfBirth(), teacher.getAddress(),
				teacher.getQualification(), teacher.getDesignation(), teacher.getClassTeacher()));
		Iterator<Teacher> teacherIterator = teacherList.iterator();
		while (teacherIterator.hasNext()) {
			System.out.println(teacherIterator.next());
		}
		List<Topics> topicList = new ArrayList<Topics>();
		Topics topics = new Topics();
		System.out.println("Enter the topics details:");
		String topicId = bufferedReader.readLine();
		String topicName = bufferedReader.readLine();
		topics.setTopicId(topicId);
		topics.setTopicName(topicName);
		topicList.add(new Topics(topics.getTopicId(), topics.getTopicName()));
		Iterator<Topics> topicIterator = topicList.iterator();
		while (topicIterator.hasNext()) {
			System.out.println(topicIterator.next());
		}
	}
}
