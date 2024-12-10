package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.ports.DB.DataAccess;

public class AirportService {
    DataAccess.MAirportRepository port;

    public AirportService(DataAccess.MAirportRepository port) {
        this.port = port;
    }

    public void createAirport(MAirport airport){
        port.create(airport);
    }

    public MAirport readAirportByCode(String code) {
        return port.readById(code);
    }
}
