package de.tjjf.Domain.ports.DB;


import de.tjjf.Domain.models.*;

public interface DataAccess {
    //public interface MAddressRepository extends CRUDRepository<MAddress, >{}
    interface MAirlineRepository extends CRUDRepository<MAirline, String>{}
    interface MAirplaneRepository extends CRUDRepository<MAirplane, Integer>{}
    interface MAirportRepository extends CRUDRepository<MAirport, String>{}
    interface MClientRepository extends CRUDRepository<MClient, Long>{}
    interface MEmployeeRepository extends CRUDRepository<MEmployee, Long>{}
    interface MFlightRepository extends CRUDRepository<MFlight, Long>{}
    interface MTicketRepository extends CRUDRepository<MTicket, Long>{}

}
