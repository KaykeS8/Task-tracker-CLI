package app;

import cli.TaskCLI;
import repository.TaskRepository;
import service.TaskService;

public class TaskTracker {
    public static void main(String[] args) {
        TaskRepository repository  = new TaskRepository();
        TaskService service = new TaskService(repository);
        TaskCLI taskCLI = new TaskCLI(service);
        taskCLI.execute(args);
    }
}
