package de.tjjf.Domain.ports.DB;

import de.tjjf.Domain.models.*;

import java.util.List;

public interface DataAccess {
    interface MAirlineRepository extends CRUDRepository<DomainAirline, String>{}
    interface MAirplaneRepository extends CRUDRepository<DomainAirplane, Integer>{}
    interface MAirportRepository extends CRUDRepository<DomainAirport, String>{}
    interface MClientRepository extends CRUDRepository<DomainClient, Long>{}
    interface MEmployeeRepository extends CRUDRepository<DomainEmployee, Long>{}
    interface MFlightRepository extends CRUDRepository<DomainFlight, Long>{
        List<DomainFlight> getAllFlights(int pageNumber, int pageSize);
    }
    interface MTicketRepository extends CRUDRepository<DomainTicket, Long>{}

}
