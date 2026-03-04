package cli;

import entities.Task;
import service.TaskService;

public class TaskCLI {

    private final TaskService service;

    public TaskCLI(TaskService service) {
        this.service = service;
    }

    public void execute(String[] args) {
        Task task;
        if (args.length == 0) {
            System.out.println("Invalid argument");
            return;
        }

        switch (args[0]) {
            case "add":
                task = service.add(args[1]);
                System.out.println("Task added succefully (ID: " + task.getId() + ")");
                break;

            case "update":
                task = service.update(Integer.parseInt(args[1]), args[2]);
                System.out.println("Task updated with succefully (ID: ) " + task.getId() + ")");
                break;

            case "remove":
                service.remove(Integer.parseInt(args[1]));
                System.out.println("Task destroyed with succefully");
                break;

            case "mark-in-progress", "mark-done":
                service.changeStatus(args[0], Integer.parseInt(args[1]));
                break;

            case "list":
                service.all();
                break;
            default:
                System.out.println("invalid argument");
        }
    }
}
