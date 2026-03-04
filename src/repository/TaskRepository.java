package repository;

import entities.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final Path path = Path.of("File", "tasks.json");

    public void save(Task task) {
        try {
            String content = Files.readString(path).trim();

            String taskJson = task.toJson();

            if (content.equals("[]")) {
                content = "[" + taskJson + "]";
            } else {
                content = content.substring(0, content.length() - 1); // remove ]
                content = content + "," + taskJson + "]";
            }

            Files.writeString(path, content);
            tasks.add(task);
        } catch (IOException e) {
            throw new RuntimeException("Error saving task", e);
        }
    }

    public Task find(int id) {
       return tasks.stream().filter( task -> task.getId() == id).findFirst().orElse(null);
    }

    public Task updateTask(int id, String description) {
        Task task = find(id);
        task.setDescription(description);
        return task;
    }

    public void destroy(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> findAll() {
        return tasks;
    }
}
