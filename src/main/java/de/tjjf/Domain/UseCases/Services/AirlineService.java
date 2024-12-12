package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.ports.DB.DataAccess;

//TODO: Braun fragen: dürfen wir das Interface implementieren oder sollen wir es im Konstruktor übergeben
public class AirlineService {
    DataAccess.MAirlineRepository port;

    public AirlineService(DataAccess.MAirlineRepository port) {
        this.port = port;
    }

    public void create(MAirline entity) {
        port.create(entity);
    }

    public MAirline readById(String s) {
        return port.readById(s);
    }

    public void update(MAirline entity) {
        port.update(entity);
    }

    public void delete(String s) {
        port.delete(s);
    }
}
