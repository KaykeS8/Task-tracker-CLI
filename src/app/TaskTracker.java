package app;

import cli.TaskCLI;
import entities.Task;
import repository.TaskRepository;
import service.TaskService;
import utils.TaskException;

import java.io.IOException;

public class TaskTracker {
    public static void main(String[] args) {

        try {
            TaskRepository repository  = new TaskRepository();
            TaskService service = new TaskService(repository);
            TaskCLI taskCLI = new TaskCLI(service);
            taskCLI.execute(args);
        } catch (TaskException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
