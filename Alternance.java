package org.StudentPortail;

import java.time.LocalDate;
import java.util.Date;

public class Alternance extends Offer{


    public Alternance(String id, LocalDate creationDate, String description, User author) {
        super(id, creationDate, description, author);
    }
}
