package service;

import entities.Task;
import repository.TaskRepository;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void add(String description) {
        Task task = new Task(description);
        System.out.println(description);
    }
}
