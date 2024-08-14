package org.StudentPortail;

import java.time.LocalDate;

public class Appliance extends Post{

    public Appliance(String id, LocalDate creationDate, String description, User author, Field field) {
        super(id, creationDate, description, author, field);
    }
}
