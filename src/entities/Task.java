package entities;

import utils.EnumTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static int COUNTER = 0;

    private int id;
    private String description;
    private EnumTask status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(){}

    public Task(String description) {
        this.id = ++COUNTER;
        this.description = description;
        this.status = EnumTask.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        setUpdatedAt(LocalDateTime.now());
    }

    public EnumTask getStatus() {
        return status;
    }

    public void setStatus(EnumTask status) {
        this.status = status;
        setUpdatedAt(LocalDateTime.now());
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updateAt) {
        this.updatedAt = updateAt;
    }

    public String toJson() {
        String safeDescription = description.replace("\"", "\\\"");

        return "{"
                + "\"id\":" + id + ","
                + "\"description\":\"" + safeDescription + "\","
                + "\"status\":\"" + status + "\","
                + "\"createdAt\":" + (createdAt != null ? "\"" + createdAt + "\"" : null) + ","
                + "\"updatedAt\":" + (updatedAt != null ? "\"" + updatedAt + "\"" : null)
                + "}";
    }

    public static Task fromJson(String json) {

        Task task = new Task();
        json = json.trim();
        json = json.substring(1, json.length() - 1);

        String[] fields = json.split(",");

        for (String item : fields) {
            String[] keyValue = item.split(":", 2);
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            switch (key) {
                case "id" -> task.setId(Integer.parseInt(value));
                case "description" -> task.description = value;
                case "status" -> task.status = EnumTask.statusToEnum(value);
                case "createdAt" -> task.setCreatedAt(LocalDateTime.parse(value));
                case "updatedAt" -> task.setUpdatedAt(LocalDateTime.parse(value));
            }
        }
        return task;
    }

    public static void setCounter(int value) {
        COUNTER = value;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return """
                ----------------------------------------
                ID: %d
                Description: %s
                Status: %s
                Created At: %s
                Updated At: %s
                ----------------------------------------
                """.formatted(
                id,
                description,
                status,
                createdAt.format(formatter),
                updatedAt.format(formatter)
        );
    }
}
