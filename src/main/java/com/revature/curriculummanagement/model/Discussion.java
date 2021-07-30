package com.revature.curriculummanagement.model;

import java.sql.Date;

public class Discussion {
	private Integer subjectId;
	private Integer unitId;
	private Integer questionNo;
	private String question;
	private String answer;
	private Date date;
	private boolean status;

	public Discussion() {
		super();
	}

	public Discussion(Integer subjectId, Integer unitId, Integer questionNo, String question, String answer, Date date,
			boolean status) {
		super();
		this.subjectId = subjectId;
		this.unitId = unitId;
		this.questionNo = questionNo;
		this.question = question;
		this.answer = answer;
		this.date = date;
		this.status = status;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Discussion [subjectId=" + subjectId + ", unitId=" + unitId + ", questionNo=" + questionNo
				+ ", question=" + question + ", answer=" + answer + ", date=" + date + ", status=" + status + "]";
	}

}
