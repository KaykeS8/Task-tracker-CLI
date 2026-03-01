package cli;

import service.TaskService;

public class TaskCLI {

    private TaskService service;

    public TaskCLI(TaskService service) {
        this.service = service;
    }

    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid argument");
            return;
        }

        switch (args[0]) {
            case "add" -> service.add(args[1]);
        }
    }
}
