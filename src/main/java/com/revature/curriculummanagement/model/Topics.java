package com.revature.curriculummanagement.model;

public class Topics {
	private String unitNo;
	private String unitName;

	public Topics() {
		super();
	}

	public Topics(String unitNo, String unitName) {
		super();
		this.unitNo = unitNo;
		this.unitName = unitName;
	}

	public String getTopicNo() {
		return unitNo;
	}

	public void setTopicNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getTopicName() {
		return unitName;
	}

	public void setTopicName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public String toString() {
		return "Topics [unitNo=" + unitNo + ", unitName=" + unitName + "]";
	}

}
