package org.moraes.sidequests.domain.tasks;

import jakarta.persistence.*;
import org.moraes.sidequests.enums.Identifier;
import org.moraes.sidequests.interfaces.Task;
import java.util.Objects;


@Entity
@Table(name = "daily_tasks")
public class DailyTask extends Task {


    public DailyTask(String name, String description, Identifier identifier) {
        super(name, description, identifier = Identifier.DAILY);
    }

    public DailyTask(){}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DailyTask dailyTask = (DailyTask) o;
        return Objects.equals(id, dailyTask.id) && Objects.equals(name, dailyTask.name) && Objects.equals(description, dailyTask.description) && Objects.equals(completed, dailyTask.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, completed);
    }


}
