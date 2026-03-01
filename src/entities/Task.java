package entities;

import utils.EnumTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static int COUNTER = 1;

    private int id;
    private String description;
    private EnumTask status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumTask getStatus() {
        return status;
    }

    public void setStatus(EnumTask status) {
        this.status = status;
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
