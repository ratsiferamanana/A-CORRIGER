package org.StudentPortail;

import java.util.Date;

public class University extends Entreprise{
    public University(String id, String userName, String phone, String email, String address, Field field, String nifStat, Date dateCreation, String description) {
        super(id, userName, phone, email, address, field, nifStat, dateCreation, description);
    }
}
