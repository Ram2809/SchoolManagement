package com.revature.Project.CurriculumManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
  public static void main(String[] args) throws IOException {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  System.out.println("Enter the number of students:");
	  Integer noOfStudents=Integer.parseInt(br.readLine());
	  List<Student> studentList=new ArrayList<Student>();
	  System.out.println("Enter the student details:");
	  for(Integer i=0;i<noOfStudents;i++)
	  {
		  Integer id=Integer.parseInt(br.readLine());
		  String name=br.readLine();
		  String dateOfBirth=br.readLine();
		  String standard=br.readLine();
		  String address=br.readLine();
		  studentList.add(new Student(id,name,dateOfBirth,standard,address));
	  }
	  Iterator studentIterator=studentList.iterator();
	  while(studentIterator.hasNext())
	  {
		  System.out.println(studentIterator.next());
	  }
  }
}
