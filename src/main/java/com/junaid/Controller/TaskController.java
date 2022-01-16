package com.junaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.Models.TaskModel;
import com.junaid.Services.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService ts;

	@GetMapping("/tasks")
	public List<TaskModel> tasks(){
		return ts.getTask();
	}

	@GetMapping("/tasks/{Taskid}")
	public TaskModel tasks(@PathVariable String Taskid){
		return ts.getTaskbyId(Long.parseLong(Taskid));
	}

	@PostMapping("/tasks")
	public List<TaskModel> addtasks(@RequestBody TaskModel tm){
		return ts.setTask(tm);
	}

	@PutMapping("/tasks/{Taskid}")
	public TaskModel puttask(@PathVariable String Taskid,@RequestBody TaskModel tm){

		return ts.putTask(Long.parseLong(Taskid),tm);
	}

	@DeleteMapping("/tasks/{Taskid}")
	public List<TaskModel> deletetask(@PathVariable String Taskid){

		return ts.removeTask(Long.parseLong(Taskid));
	}

}