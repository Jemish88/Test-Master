package com.example.testmaster.repository;

import com.example.testmaster.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class TaskRepositoryIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void createTask_ShouldPersistTask() {
        Task task = new Task();
        task.setTitle("Integration Task");

        Task savedTask = taskRepository.save(task);

        assertNotNull(savedTask.getId());
        assertEquals("Integration Task", savedTask.getTitle());
    }

    @Test
    void findAllTasks_ShouldReturnAllTasks() {
        Task task1 = new Task();
        task1.setTitle("Task 1");
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setTitle("Task 2");
        taskRepository.save(task2);

        List<Task> tasks = taskRepository.findAll();

        assertEquals(2, tasks.size());
    }
}