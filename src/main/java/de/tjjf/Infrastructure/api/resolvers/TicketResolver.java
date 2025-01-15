package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.BookingPortImpl;
import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.MapperInput.ClientMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.PaymentMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.TicketMapperInput;
import de.tjjf.Infrastructure.api.mapper.*;
import de.tjjf.Infrastructure.api.models.*;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class TicketResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    //TODO: Ticket Port Impl, bzw rename von booking zu ticket außer ich bin zu blöd die Logik zu verstehen - Tom
    public APITicket addBooking(APITicketInput newBooking, APIPaymentInput payment) {
        APITicket apiTicket = new TicketMapperInput().toDomain(0L, newBooking);
        APIPayment apiPayment = new PaymentMapperInput().toDomain(payment);
        return new APITicketMapper().toAPIEntity(new BookingPortImpl().addBooking(new APITicketMapper().toDomainEntity(apiTicket), new APIPaymentMapper().toDomainEntity(apiPayment)));
    }

    public APITicket readTicketById(int ticketId) {
        return new APITicketMapper().toAPIEntity(new BookingPortImpl().readTicketById(ticketId));
    }

    public void upgradeSeatingClass(int ticketId, APITicketInput.SeatingClass newSeatingClass) {
        MTicket.SeatingClass seatingClass = Enum.valueOf(MTicket.SeatingClass.class, newSeatingClass.name());
        new BookingPortImpl().upgradeSeatingClass(ticketId, seatingClass);
    }

    public void upgradeLuggageWeight(int ticketId, int newWeight) {
        new BookingPortImpl().upgradeLuggageWeight(ticketId, newWeight);
    }

    public void cancelTicketClient(int clientId, int flightNum) {
        APIClient apiClient = new ClientResolver().readClientById(clientId);
        new BookingPortImpl().cancelTicket(new APIClientMapper().toDomainEntity(apiClient), flightNum);
    }

    public void cancelTicketEmployee(int employeeId, int flightNum) {
        APIEmployee apiEmployee = new EmployeeResolver().readEmployeeById(employeeId);
        new BookingPortImpl().cancelTicket(new APIEmployeeMapper().toDomainEntity(apiEmployee), flightNum);
    }

}
