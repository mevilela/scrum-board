package com.workshop.scrumboard.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String status;
//    public String assingee;

    // Each Task belongs to one User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignee")
    private User assignee;

    public Task() {
        this.status = "To Do";
    }

    public Task(String name, User assignee) {
        this.name = name;
        this.status = "To Do";
        this.assignee = assignee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assingee) {
        this.assignee = assingee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", assignee=" + assignee +
                '}';
    }
}
