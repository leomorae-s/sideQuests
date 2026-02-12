package org.moraes.sidequests.controllers;

import org.moraes.sidequests.DTOs.TaskDTO;
import org.moraes.sidequests.factorys.TaskFactory;
import org.moraes.sidequests.interfaces.Task;
import org.moraes.sidequests.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class DailyTaskController {

    private final TaskService taskService;

    private DailyTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO data) {

        if (data.name().isEmpty())
            throw new IllegalArgumentException("Dados faltantes");


        Task task = TaskFactory.taskFactory(data);

        taskService.create(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(data);
    }

    @DeleteMapping("/delete/task")
    public ResponseEntity<TaskDTO> deleteTask(@RequestBody TaskDTO dto) {

        taskService.delete(dto.id());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/task/{id}")
    public ResponseEntity<TaskDTO> getTask(@RequestBody TaskDTO dto) {

        TaskDTO taskDTO = taskService.get(dto.id());

        return ResponseEntity.ok(taskDTO);
    }

    @GetMapping("get/tasks/")
    public List<TaskDTO> getTasks() {
        return taskService.get().stream()
                .map(t -> new TaskDTO(t.getName(), t.getDescription(), t.getCompletion(), t.getId(), t.getIdentifier()))
                .collect(Collectors.toList());
    }

    @PutMapping("update/task/{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO dto) {

        taskService.update(dto);

        return ResponseEntity.ok(taskService.get(dto.id()));
    }
}
