package com.junaid.Models;

public class TaskModel {

	@Override
	public String toString() {
		return "TaskModel [task_id=" + task_id + ", name=" + name + ", desc=" + desc + "]";
	}

	long task_id;
	String name;
	String desc;

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public TaskModel(long task_id, String name, String desc) {
		super();
		this.task_id = task_id;
		this.name = name;
		this.desc = desc;
	}

	public TaskModel() {

	}

}