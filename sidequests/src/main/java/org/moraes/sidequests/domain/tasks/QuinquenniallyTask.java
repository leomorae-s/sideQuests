package org.moraes.sidequests.domain.tasks;

import jakarta.persistence.*;
import org.moraes.sidequests.enums.Identifier;
import org.moraes.sidequests.interfaces.Task;
import java.util.Objects;


@Entity
@Table(name = "quinquennially")
public class QuinquenniallyTask extends Task {

    public QuinquenniallyTask(String name, String description, Identifier identifier) {
        super(name, description, identifier = Identifier.QUINQUENNIALLY);
    }

    public QuinquenniallyTask(){}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuinquenniallyTask that = (QuinquenniallyTask) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "QuinquenniallyTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
