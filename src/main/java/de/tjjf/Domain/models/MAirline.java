package de.tjjf.Domain.models;

import java.util.Date;

public class MAirline {
    private String name;

    private Date foundationYear;

    private String headQuarters;

    public MAirline(String name, Date foundationYear, String headQuarters) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
    }

    public String getName() {
        return name;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }
}
