package org.moraes.sidequests.services;


import jakarta.persistence.EntityNotFoundException;
import org.moraes.sidequests.DTOs.TaskDTO;
import org.moraes.sidequests.interfaces.Task;
import org.moraes.sidequests.repositorys.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void create(Task task) {
        if (task.getName().isEmpty())
            throw new EntityNotFoundException("Tarefa de id " + task.getId() + "não encontrada.");
        repository.save(task);
    }

    public void delete(UUID uuid) {
        Optional<Task> t = repository.findById(uuid);
        if (t.isEmpty())
            throw new EntityNotFoundException("Deve fornecer o id da tarefa.");

        repository.deleteById(uuid);

    }

    public TaskDTO get(UUID uuid) {


        Optional<Task> optionalTask = repository.findById(uuid);

        if (optionalTask.isEmpty())
            throw new EntityNotFoundException("Task não encontrada");

        Task task = optionalTask.get();

        return new TaskDTO(task.getName(), task.getDescription(), task.getCompletion(), task.getId(), task.getIdentifier());
    }

    public List<Task> get() {
        return repository.findAll();
    }

    public void update(TaskDTO dto) {
        Optional<Task> optionalTask = repository.findById(dto.id());

        if (optionalTask.isEmpty())
            throw new EntityNotFoundException("Task não encontrada");

        Task task = optionalTask.get();

        if (!dto.name().isEmpty())
            task.setName(dto.name());


        if (!dto.description().isEmpty())
            task.setDescription(dto.description());

        if (dto.completed() != null)
            task.setCompletion(dto.completed());

        repository.save(task);

    }


    @Scheduled(cron = "0 0 0 * * *")
    public void restartDailyTask() {
        repository.updateDailyTasks();
    }

}
