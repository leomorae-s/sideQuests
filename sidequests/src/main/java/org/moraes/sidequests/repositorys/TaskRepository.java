package org.moraes.sidequests.repositorys;

import org.moraes.sidequests.interfaces.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Query("UPDATE daily_tasks SET completed=FALSE")
    void updateDailyTasks();
}
