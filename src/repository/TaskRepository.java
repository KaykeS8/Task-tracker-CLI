package repository;

import entities.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        try {
            Path path = Paths.get("task-tracker-cli/File/tasks.json");
            String content = Files.readString(path).trim();

            String taskJson = task.toJson();

            if (content.equals("[]")) {
                content = "[" + taskJson + "]";
            } else {
                content = content.substring(0, content.length() - 1); // remove ]
                content = content + "," + taskJson + "]";
            }

            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tasks.add(task);
    }

    public Task find(int id) {
       return tasks.stream().filter( task -> task.getId() == id).findFirst().orElse(null);
    }

    public void destroy(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> findAll() {
        return tasks;
    }
}
