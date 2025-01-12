package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MTicket;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.TicketAPIOperation;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.EmployeeUpdateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class UpgradeLuggageWeightUseCase {

    public void upgradeLuggageWeight(MTicket ticket, int newWeight) throws IllegalArgumentException {
            ticket.upgradeLuggageWeight(newWeight);
            new TicketUpdateImpl(new TicketMapper().toEntity(ticket), ticket.getTicketId()).execute();
    }
}