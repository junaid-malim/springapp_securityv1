package com.junaid.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.junaid.Models.TaskModel;

@Service
public class TaskServicesImpl implements TaskService {

	List<TaskModel> list;

	public TaskServicesImpl() {
		list=new ArrayList<>();

		TaskModel tm=new TaskModel();
		tm.setTask_id(100);
		tm.setName("Task 1");
		tm.setDesc("First Task");

		list.add(tm);
		list.add(new TaskModel(110,"Task 2","Second Task"));

	}

	@Override
	public List<TaskModel> getTask() {

		return list;
	}

	@Override
	public List<TaskModel> setTask(TaskModel tm) {
		list.add(tm);
		return list;
	}

	@Override
	public List<TaskModel> removeTask(long i) {

		list=list.stream().filter(e->e.getTask_id()!=i).collect(Collectors.toList());

		return list;
	}

	@Override
	public TaskModel getTaskbyId(long parseLong) {

		TaskModel tm=new TaskModel();

		for(TaskModel tm1:list) {
			if(tm1.getTask_id()==parseLong) {
				tm=tm1;
				break;
			}
		}

		return tm;
	}

	@Override
	public TaskModel putTask(long taskid, TaskModel tm) {

		list.forEach(e->{
			if(e.getTask_id()==taskid) {
				e.setName(tm.getName());
				e.setDesc(tm.getDesc());
			}
		});

		return tm;
	}

}