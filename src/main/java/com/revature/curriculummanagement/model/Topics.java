package com.revature.curriculummanagement.model;

public class Topics {
	private String topicId;
	private String topicName;

	public Topics() {
		super();
	}

	public Topics(String topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Topics [topicId=" + topicId + ", topicName=" + topicName + "]";
	}

}
