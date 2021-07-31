package com.revature.curriculummanagement.model;

public class Discussion {
	private Integer subjectId;
	private Integer unitId;
	private String questionNo;
	private String question;
	private String answer;
	private String date;

	public Discussion() {
		super();
	}

	public Discussion(String questionNo, String question, String answer, Integer unitId,Integer subjectId, 
			String date) {
		super();
		this.questionNo = questionNo;
		this.question = question;
		this.answer = answer;
		this.unitId = unitId;
		this.subjectId = subjectId;
		this.date = date;
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

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Discussion [subjectId=" + subjectId + ", unitId=" + unitId + ", questionNo=" + questionNo
				+ ", question=" + question + ", answer=" + answer + ", date=" + date + "]";
	}

}
