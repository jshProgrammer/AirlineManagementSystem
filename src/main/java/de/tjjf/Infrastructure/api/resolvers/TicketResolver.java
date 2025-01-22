package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.adapter.TicketPortImpl;
import de.tjjf.Domain.models.DomainTicket;
import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.MapperInput.PaymentMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.TicketMapperInput;
import de.tjjf.Infrastructure.api.mapper.*;
import de.tjjf.Infrastructure.api.models.*;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class TicketResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    public APITicket addTicket(APITicketInput newBooking, APIPaymentInput payment) {
        APITicket apiTicket = new TicketMapperInput().toDomain(0L, newBooking);
        APIPayment apiPayment = new PaymentMapperInput().toDomain(payment);
        return new APITicketMapper().toAPIEntity(new TicketPortImpl().addBooking(new APITicketMapper().toDomainEntity(apiTicket), new APIPaymentMapper().toDomainEntity(apiPayment)));
    }

    public APITicket readTicketById(long ticketId) {
        return new APITicketMapper().toAPIEntity(new TicketPortImpl().readTicketById(ticketId));
    }

    public void upgradeSeatingClass(long ticketId, APITicketInput.SeatingClass newSeatingClass) {
        DomainTicket.SeatingClass seatingClass = Enum.valueOf(DomainTicket.SeatingClass.class, newSeatingClass.name());
        new TicketPortImpl().upgradeSeatingClass(ticketId, seatingClass);
    }

    public void upgradeLuggageWeight(long ticketId, int newWeight) {
        new TicketPortImpl().upgradeLuggageWeight(ticketId, newWeight);
    }

    public void cancelTicketClient(long clientId, long flightNum) {
        APIClient apiClient = new ClientResolver().readClientById(clientId);
        new TicketPortImpl().cancelTicket(new APIClientMapper().toDomainEntity(apiClient), flightNum);
    }

    public void cancelTicketEmployee(int employeeId, int flightNum) {
        APIEmployee apiEmployee = new EmployeeResolver().readEmployeeById(employeeId);
        new TicketPortImpl().cancelTicket(new APIEmployeeMapper().toDomainEntity(apiEmployee), flightNum);
    }

}
