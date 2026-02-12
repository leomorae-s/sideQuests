package org.moraes.sidequests.domain.tasks;

import jakarta.persistence.*;
import org.moraes.sidequests.enums.Identifier;
import org.moraes.sidequests.interfaces.Task;
import java.util.Objects;


@Entity
@Table(name = "yearly")
public class YearlyTask extends Task {

    public YearlyTask (String name, String description, Identifier identifier) {
        super(name, description, identifier = Identifier.YEARLY);
    }

    public YearlyTask() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        YearlyTask that = (YearlyTask) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(completed, that.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, completed);
    }

    @Override
    public String toString() {
        return "YearlyTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
