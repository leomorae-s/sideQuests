package org.moraes.sidequests.interfaces;

import jakarta.persistence.*;
import org.moraes.sidequests.enums.Identifier;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    protected UUID id;
    @Column(name = "name")
    protected String name;
    @Column(name = "description")
    protected String description;
    @Column(name = "completed")
    protected Boolean completed = false;

    @Transient
    private Identifier identifier;

    public Task(String name, String description, Identifier identifier) {
        this.name = name;
        this.description = description;
        this.identifier = identifier;
    }

    public Task() {}


    public String getName() {
        return name;
    }


    public UUID getId() {
        return id;
    }


    public Boolean getCompletion() {
        return completed;
    }


    public void setName(String name) {

        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompletion(boolean completed) {

        this.completed = completed;
    }


    public String getDescription() {
        return description;
    }

    public Identifier getIdentifier() {return identifier;}

}
