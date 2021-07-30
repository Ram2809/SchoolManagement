package com.revature.curriculummanagement.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.Student;

public class ClassServiceImpl implements ClassService {
	static List<Classes> classList = new ArrayList<Classes>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addClassDetails(Classes classes) {
		classList.add(new Classes(classes.getClassId(),classes.getClassName()));
	}

	public void getClassDetails(Classes classes) {
		Iterator<Classes> classIterator = classList.iterator();
		while (classIterator.hasNext()) {
			System.out.println(classIterator.next());
		}
	}

	public void updateClassDetails(Classes classes)
			throws NumberFormatException, IOException, InvalidChoiceException {
		System.out.println("Enter the class id:");
		Integer updateId = Integer.parseInt(br.readLine());
		System.out.println("Enter the new class name");
		String updateName=br.readLine();
		for(Classes classlist : classList)
		{
			if(classlist.getClassId().equals(updateId))
			{
				classlist.setClassName(updateName);
				break;
			}
		}
	}

	public void deleteClassDetails(Classes classes) throws NumberFormatException, IOException {
		System.out.println("Enter the class id:");
		Integer deleteId = Integer.parseInt(br.readLine());
		Iterator<Classes> classIterator = classList.iterator();
		while (classIterator.hasNext()) {
			if (classIterator.next().getClassId().equals(deleteId)) {
				classIterator.remove();
				break;
			}
		}
	}
}