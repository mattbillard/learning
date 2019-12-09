/*
package springboot.post;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

  private List<Task> tasks = new ArrayList<>();

  public TaskController() {
  }

  @PostMapping(path = "/tasks")
  public Task addTask(@RequestBody Task task){
    tasks.add(task);
    return task;
  }

  @GetMapping(path = "/tasks/{id}")
  public Task getTask(@PathVariable int id){
    return tasks.get(id - 1);
  }
}

class Task {
  private int id;
  private String name;
  private String description;
  private boolean completed;

  public Task() {
  }

  public Task(int id, String name, String description, boolean completed) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.completed = completed;
  }

  // getters and setters
}
*/