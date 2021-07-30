package com.revature.curriculummanagement.model;

public class Classes {
	private Integer classRoomNo;
	private String standard;
	private String section;

	public Classes() {
		super();
	}

	public Classes(Integer classRoomNo, String standard, String section) {
		super();
		this.classRoomNo = classRoomNo;
		this.standard = standard;
		this.section = section;
	}

	public Integer getClassRoomNo() {
		return classRoomNo;
	}

	public void setClassRoomNo(Integer classRoomNo) {
		this.classRoomNo = classRoomNo;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Classes [classRoomNo=" + classRoomNo + ", standard=" + standard + ", section=" + section + "]";
	}

}
