package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import de.tjjf.Adapter.APIAdapter.BookingPortImpl;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.mapper.*;
import de.tjjf.Infrastructure.api.models.*;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class TicketResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    //TODO: Ticket Port Impl, bzw rename von booking zu ticket außer ich bin zu blöd die Logik zu verstehen - Tom
    public void addBooking(APITicketInput ticket, APIPaymentInput payment) {
        APITicket.SeatingClass seatingClass = APITicket.SeatingClass.valueOf(ticket.getSeatingClass().name());
        APITicket.TicketStatus ticketStatus = APITicket.TicketStatus.valueOf(ticket.getTicketStatus().name());

        APITicket apiTicket = new APITicket(ticket.getTicketId(), ticket.getPersonId(), ticket.isClient(), ticket.getFlightNum(), ticket.getDateTimeOfBooking(), ticket.getTotalPrice(), ticket.getSeatNum(), seatingClass, ticketStatus, ticket.getWeightOfLuggage());
        APIPayment apiPayment = new APIPayment(payment.getCardNumber(), payment.getExpMonth(), payment.getExpYear(), payment.getCvc());
        new BookingPortImpl().addBooking(new APITicketMapper().toDomainEntity(apiTicket), new APIPaymentMapper().toDomainEntity(apiPayment));
    }

    public APITicket readTicketById(int id) {
        return new APITicketMapper().toAPIEntity(new BookingPortImpl().readTicketById(id));
    }

    //TODO: Seating class evtl anders übergeben, bzw. nochmal Mapper überprüfen
    public void upgradeSeatingClass(int ticketId, APITicketInput.SeatingClass newSeatingClass) {
        MTicket.SeatingClass seatingClass = Enum.valueOf(MTicket.SeatingClass.class, newSeatingClass.name());
        new BookingPortImpl().upgradeSeatingClass(ticketId, seatingClass);
    }

    public void upgradeLuggageWeight(int ticketId, int newWeight) {
        new BookingPortImpl().upgradeLuggageWeight(ticketId, newWeight);
    }
    //TODO: Nochmal drüberschauen ob das so grob passt
    public void cancelTicketClient(APIClientInput client, int flightNum) {
        APIAddress apiAddress = new APIAddress(client.getAddress().street, client.getAddress().number, client.getAddress().zipcode, client.getAddress().city, client.getAddress().country);
        APIClient apiClient = new APIClient(client.getClientId(), client.getFirstName(), client.getMiddleNames(), client.getLastName(), client.getDateOfBirth(), client.getPhoneNumber(), apiAddress, client.getEmail(), client.isBusinessClient());
        new BookingPortImpl().cancelTicket(new APIClientMapper().toDomainEntity(apiClient), flightNum);
    }

    public void cancelTicketEmployee(APIEmployeeInput employee, int flightNum) {
        APIAddress apiAddress = new APIAddress(employee.getAddress().street, employee.getAddress().number, employee.getAddress().zipcode, employee.getAddress().city, employee.getAddress().country);
        APIEmployee apiEmployee = new APIEmployee(employee.getEmployeeId(), employee.getFirstName(), employee.getMiddleNames(), employee.getLastName(), employee.getAirline(), employee.getPhoneNumber(), apiAddress, employee.getEmail(), employee.getDateOfBirth());
        new BookingPortImpl().cancelTicket(new APIEmployeeMapper().toDomainEntity(apiEmployee), flightNum);
    }

}
