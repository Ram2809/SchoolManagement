package com.revature.curriculummanagement.model;

public class HeadMaster {
	private Integer id;
	private String name;

	public HeadMaster() {
		super();
	}

	public HeadMaster(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HeadMaster [id=" + id + ", name=" + name + "]";
	}

}
