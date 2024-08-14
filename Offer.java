package org.StudentPortail;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Offer extends Post{
    private double salary;
    private Date startingDate;
    private Date endDate;
    private boolean isAvailable;
    private List<Student> candidates;

    public Offer(String id, LocalDate creationDate, String description, User author, Field field,double salary, Date startingDate, Date endDate, boolean isAvailable, List<Student> candidates) {
        super(id, creationDate, description, author, field);
        this.salary = salary;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.isAvailable = isAvailable;
        this.candidates = candidates;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Student> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Student> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "salary=" + salary +
                ", startingDate=" + startingDate +
                ", endDate=" + endDate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
