package com.revature.curriculummanagement.model;

public class TeacherDetails {
	private Integer teacher_id;
	private Integer classRoomNo;
	private Integer subjectId;

	public TeacherDetails() {
		super();
	}

	public TeacherDetails(Integer teacher_id, Integer classRoomNo, Integer subjectId) {
		super();
		this.teacher_id = teacher_id;
		this.classRoomNo = classRoomNo;
		this.subjectId = subjectId;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Integer getClassRoomNo() {
		return classRoomNo;
	}

	public void setClassRoomNo(Integer classRoomNo) {
		this.classRoomNo = classRoomNo;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "TeacherDetails [teacher_id=" + teacher_id + ", classRoomNo=" + classRoomNo + ", subjectId=" + subjectId
				+ "]";
	}

}
