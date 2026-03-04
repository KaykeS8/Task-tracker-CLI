package service;

import entities.Task;
import repository.TaskRepository;
import utils.EnumTask;
import utils.TaskException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        ensureFileExist();
        this.taskRepository = taskRepository;
    }

    public Task add(String description) {
        Task task = new Task(description);
        ensureFileExist();
        taskRepository.save(task);
        return task;
    }

    public Task update(int id, String description) {
        Task task = getTaskOrThrow(id);
        task.setDescription(description);
        return task;
    }

    public void remove(int id) {
        Task task = getTaskOrThrow(id);
        taskRepository.destroy(id);
    }

    public void changeStatus(String status, int id) {
        Task task = getTaskOrThrow(id);
        switch (status) {
            case "mark-in-progress" -> task.setStatus(EnumTask.IN_PROGRESS);
            case "mark-done" -> task.setStatus(EnumTask.DONE);
        }
    }

    public void all() {
       List<Task> tasks = taskRepository.findAll();
       tasks.forEach(System.out::println);
    }

    public void all(String option) {
        List<Task> tasks = taskRepository.findAll().stream()
                .filter(task -> EnumTask.statusToString(task.getStatus()).equals(option))
                .toList();
        if (tasks.isEmpty()) {
            System.out.println("no task (" + option + ")");
        }

        tasks.forEach(System.out::println);
    }

    private Task getTaskOrThrow(int id) {
        Task task = taskRepository.find(id);
        if(task == null) {
            throw new TaskException("Task not found with id: " + id);
        }
        return task;
    }

    private static void ensureFileExist() {
        try {
            Path directory = Path.of("File");
            Path filePath = directory.resolve("tasks.json");

            // Cria o diretório se não existir
            if (Files.notExists(directory)) {
                Files.createDirectories(directory);
            }

            // Cria o arquivo se não existir
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
                Files.writeString(filePath, "[]"); // inicia como array JSON vazio
            }

        } catch (IOException e) {
            throw new RuntimeException("Error creating tasks.json file", e);
        }
    }
}
