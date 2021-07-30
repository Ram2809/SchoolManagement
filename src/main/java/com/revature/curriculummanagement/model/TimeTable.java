package com.revature.curriculummanagement.model;

public class TimeTable {
	private String day;
	private String periodOne;
	private String periodTwo;
	private String periodThree;
	private String periodFour;
	private String periodFive;
	private String periodSix;

	public TimeTable() {
		super();
	}

	public TimeTable(String day, String periodOne, String periodTwo, String periodThree, String periodFour,
			String periodFive, String periodSix) {
		super();
		this.day = day;
		this.periodOne = periodOne;
		this.periodTwo = periodTwo;
		this.periodThree = periodThree;
		this.periodFour = periodFour;
		this.periodFive = periodFive;
		this.periodSix = periodSix;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPeriodOne() {
		return periodOne;
	}

	public void setPeriodOne(String periodOne) {
		this.periodOne = periodOne;
	}

	public String getPeriodTwo() {
		return periodTwo;
	}

	public void setPeriodTwo(String periodTwo) {
		this.periodTwo = periodTwo;
	}

	public String getPeriodThree() {
		return periodThree;
	}

	public void setPeriodThree(String periodThree) {
		this.periodThree = periodThree;
	}

	public String getPeriodFour() {
		return periodFour;
	}

	public void setPeriodFour(String periodFour) {
		this.periodFour = periodFour;
	}

	public String getPeriodFive() {
		return periodFive;
	}

	public void setPeriodFive(String periodFive) {
		this.periodFive = periodFive;
	}

	public String getPeriodSix() {
		return periodSix;
	}

	public void setPeriodSix(String periodSix) {
		this.periodSix = periodSix;
	}

	@Override
	public String toString() {
		return "TimeTable [day=" + day + ", periodOne=" + periodOne + ", periodTwo=" + periodTwo + ", periodThree="
				+ periodThree + ", periodFour=" + periodFour + ", periodFive=" + periodFive + ", periodSix=" + periodSix
				+ "]";
	}

}
