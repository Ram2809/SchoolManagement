package com.revature.curriculummanagement.model;

public class Topics {
	private String unitNo;
	private String unitName;
	private String startDate;
	private String endDate;
	private boolean status;
	private Integer subjectId;
	private Integer classRoomNo;

	public Topics() {
		super();
	}

	public Topics(String unitNo, String unitName, String startDate, String endDate, boolean status, Integer subjectId,
			Integer classRoomNo) {
		super();
		this.unitNo = unitNo;
		this.unitName = unitName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.subjectId = subjectId;
		this.classRoomNo = classRoomNo;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getClassRoomNo() {
		return classRoomNo;
	}

	public void setClassRoomNo(Integer classRoomNo) {
		this.classRoomNo = classRoomNo;
	}

	@Override
	public String toString() {
		return "Topics [unitNo=" + unitNo + ", unitName=" + unitName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + ", subjectId=" + subjectId + ", classRoomNo=" + classRoomNo + "]";
	}

}
