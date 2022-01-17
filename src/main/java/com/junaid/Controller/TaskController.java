package com.junaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.junaid.Models.TaskModel;
import com.junaid.Services.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService ts;

	@GetMapping("/tasks")
	public ResponseEntity<String> tasks(){

		StringBuilder stringBuilder=new StringBuilder();
		for (TaskModel tm: ts.getTask()) {
			stringBuilder.append("<ul> " +
					"<li><h1>"+tm.getTask_id()+"</h1></li>" +
					"<li>"+tm.getName()+"</li>" +
					"<li>"+tm.getDesc()+"</li>" +
					"</ul><br>");
		}
		return new ResponseEntity<String>(stringBuilder.toString(), HttpStatus.OK);
	}

	@GetMapping("/tasks/{Taskid}")
	public ResponseEntity<String> tasks(@PathVariable String Taskid){
		TaskModel tm= ts.getTaskbyId(Long.parseLong(Taskid));
		StringBuilder stringBuilder=new StringBuilder();
			stringBuilder.append("<ul> " +
					"<li><h1>"+tm.getTask_id()+"</h1></li>" +
					"<li>"+tm.getName()+"</li>" +
					"<li>"+tm.getDesc()+"</li>" +
					"</ul><br>");
		return new ResponseEntity<String>(stringBuilder.toString(),HttpStatus.OK);
	}

	@PostMapping("/tasks")
	public ResponseEntity<String> addtasks(@RequestBody TaskModel tm){
		StringBuilder stringBuilder=new StringBuilder();
		for (TaskModel tm1: ts.getTask()) {
			stringBuilder.append("<ul> " +
					"<li><h1>"+tm1.getTask_id()+"</h1></li>" +
					"<li>"+tm1.getName()+"</li>" +
					"<li>"+tm1.getDesc()+"</li>" +
					"</ul><br>");
		}
		return new ResponseEntity<String>(stringBuilder.toString(), HttpStatus.OK);
	}

	@PutMapping("/tasks/{Taskid}")
	public ResponseEntity<String> puttask(@PathVariable String Taskid,@RequestBody TaskModel tm){
		TaskModel tm1= ts.getTaskbyId(Long.parseLong(Taskid));
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("<ul> " +
				"<li><h1>"+tm1.getTask_id()+"</h1></li>" +
				"<li>"+tm1.getName()+"</li>" +
				"<li>"+tm1.getDesc()+"</li>" +
				"</ul><br>");
		return new ResponseEntity<String>(stringBuilder.toString(),HttpStatus.OK);
	}

	@DeleteMapping("/tasks/{Taskid}")
	public ResponseEntity<String> deletetask(@PathVariable String Taskid){
		StringBuilder stringBuilder=new StringBuilder();
		for (TaskModel tm1: ts.getTask()) {
			stringBuilder.append("<ul> " +
					"<li><h1>"+tm1.getTask_id()+"</h1></li>" +
					"<li>"+tm1.getName()+"</li>" +
					"<li>"+tm1.getDesc()+"</li>" +
					"</ul><br>");
		}
		return new ResponseEntity<String>(stringBuilder.toString(), HttpStatus.OK);
	}
//	@GetMapping("/tasks")
//	public List<TaskModel> tasks(){
//		return ts.getTask();
//	}
//
//	@GetMapping("/tasks/{Taskid}")
//	public TaskModel tasks(@PathVariable String Taskid){
//		return ts.getTaskbyId(Long.parseLong(Taskid));
//	}
//
//	@PostMapping("/tasks")
//	public List<TaskModel> addtasks(@RequestBody TaskModel tm){
//		return ts.setTask(tm);
//	}
//
//	@PutMapping("/tasks/{Taskid}")
//	public TaskModel puttask(@PathVariable String Taskid,@RequestBody TaskModel tm){
//
//		return ts.putTask(Long.parseLong(Taskid),tm);
//	}
//
//	@DeleteMapping("/tasks/{Taskid}")
//	public List<TaskModel> deletetask(@PathVariable String Taskid){
//
//		return ts.removeTask(Long.parseLong(Taskid));
//	}

}