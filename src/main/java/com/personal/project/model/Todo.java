package com.personal.project.model;

public class Todo {
	private String name;
	private String task;
	private int id;
	public Todo(int id, String name, String task) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
	}
	public Todo(String name, String task) {
		super();
		this.name = name;
		this.task = task;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Todo [name=" + name + ", task=" + task + "]";
	}
	
	

}
