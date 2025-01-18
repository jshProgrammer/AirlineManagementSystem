package de.tjjf.Domain.UseCases.Services;

import de.tjjf.Adapter.DatabaseAdapter.MTicketRepositoryImpl;
import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.UseCases.*;
import de.tjjf.Domain.models.MPayment;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class TicketService extends AuthorizedUseCase {
    DataAccess.MTicketRepository ticketPort;
    DataAccess.MClientRepository clientPort;
    DataAccess.MEmployeeRepository employeePort;

    public TicketService(DataAccess.MTicketRepository ticketPort) {
        super(AuthenticationUseCase.getInstance());
        this.ticketPort = ticketPort;
    }

    public TicketService(DataAccess.MTicketRepository ticketPort, DataAccess.MClientRepository clientPort, DataAccess.MEmployeeRepository employeePort) {
        super(AuthenticationUseCase.getInstance());
        this.ticketPort = ticketPort;
        this.clientPort = clientPort;
        this.employeePort = employeePort;
    }

    public MTicket addBooking(MTicket newBooking, MPayment mPayment) {
        //new CancelTicketUseCase().authorize();
        if(AddBookingUseCase.addBooking(newBooking, mPayment)){
            return ticketPort.create(newBooking);
        }
        return null;
    }

    public MTicket readTicketById(long id) {
        //new CancelTicketUseCase().authorize();
        return ticketPort.readById(id);
    }

    public void upgradeSeatingClass(long ticketId, MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException {
        //new CancelTicketUseCase().authorize();
        MTicket ticket = readTicketById(ticketId);
        new UpgradeSeatingClassUseCase(new MTicketRepositoryImpl()).updateSeatingClassIfAvailable(ticket, newSeatingClass);
    }

    public void upgradeLuggageWeight(long ticketId, int newWeight) throws IllegalArgumentException {
        //new CancelTicketUseCase().authorize();
        MTicket ticket = ticketPort.readById(ticketId);
        new UpgradeLuggageWeightUseCase(ticketPort).upgradeLuggageWeight(ticket, newWeight);
    }

    public void cancelTicket(MPerson person, int flightnum){
        //new CancelTicketUseCase().authorize();
        new CancelTicketUseCase(ticketPort, clientPort, employeePort).cancelTicket(person, flightnum);
    }
}
