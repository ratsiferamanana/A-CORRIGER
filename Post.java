package org.StudentPortail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private LocalDate creationDate;
    private String description;
    private User author;
    private Field field;
    public Post(String id, LocalDate creationDate, String description, User author, Field field) {
        this.id = id;
        this.creationDate = creationDate;
        this.description = description;
        this.author = author;
        this.field = field;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", field=" + field +
                '}';
    }
}
