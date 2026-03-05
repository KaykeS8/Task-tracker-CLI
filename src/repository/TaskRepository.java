package repository;

import entities.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks;
    private final Path path = Path.of("File", "tasks.json");

    public TaskRepository() {
        this.tasks = loadTasks();
        int maxId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0);

        Task.setCounter(maxId);
    }

    public void save(Task task) {
        tasks.add(task);
        persist();
    }

    public Task find(int id) {
       return tasks.stream().filter( task -> task.getId() == id).findFirst().orElse(null);
    }

    public Task updateTask(int id, String description) {
        Task task = find(id);
        if (task != null) {
            task.setDescription(description);
            persist();
        }
        return task;
    }

    public void destroy(int id) {
        tasks.removeIf(task -> task.getId() == id);
        persist();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public List<Task> loadTasks() {
        List<Task> tasks_stored = new ArrayList<>();
        try {
            String jsonContent = Files.readString(path);
            if (jsonContent.equals("[]")) return tasks_stored;
            String[] taskList = jsonContent.replace("[", "").replace("]", "").split("},");
            for (String taskJson : taskList) {
                if (!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                    tasks_stored.add(Task.fromJson(taskJson));
                } else {
                    tasks_stored.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return tasks_stored;
    }

    public void persistAll() {
        persist();
    }

    private void persist() {
        try {
            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < tasks.size(); i++) {
                json.append(tasks.get(i).toJson());
                if (i < tasks.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            Files.writeString(path, json.toString());

        } catch (IOException e) {
            throw new RuntimeException("Error persisting tasks", e);
        }
    }

}
