package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;

public class UpgradeLuggageWeightUseCase {
    DataAccess.MTicketRepository ticketPort;

    public UpgradeLuggageWeightUseCase(DataAccess.MTicketRepository ticketPort) {
        this.ticketPort = ticketPort;
    }

    public void upgradeLuggageWeight(MTicket ticket, int newWeight) throws IllegalArgumentException {
            ticket.upgradeLuggageWeight(newWeight);
            ticketPort.update(ticket);
    }
}