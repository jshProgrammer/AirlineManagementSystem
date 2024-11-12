package de.tjjf.Infrastructure.persistence.DBOperations;

import de.tjjf.Infrastructure.persistence.entities.Airline;

public class DBAirlineImpl extends DBOperationTemplate{
    Airline airline;

    public DBAirlineImpl(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void create() {
        em.persist(airline);
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {
        this.em.merge(this.airline);
    }

    @Override
    public void delete() {

    }
}
