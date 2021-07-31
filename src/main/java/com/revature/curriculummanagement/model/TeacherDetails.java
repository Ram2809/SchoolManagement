package com.revature.curriculummanagement.model;

public class TeacherDetails {
	private Integer teacherId;
	private Integer classRoomNo;
	private Integer subjectId;

	public TeacherDetails() {
		super();
	}

	public TeacherDetails(Integer teacherId, Integer classRoomNo, Integer subjectId) {
		super();
		this.teacherId = teacherId;
		this.classRoomNo = classRoomNo;
		this.subjectId = subjectId;
	}

	public Integer getTeacher_id() {
		return teacherId;
	}

	public void setTeacher_id(Integer teacherId) {
		this.teacherId = teacherId;
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
		return "TeacherDetails [teacherId=" + teacherId + ", classRoomNo=" + classRoomNo + ", subjectId=" + subjectId
				+ "]";
	}

}
