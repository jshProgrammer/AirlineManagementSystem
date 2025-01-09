package de.tjjf.Adapter.DatabaseAdapter;

import de.tjjf.Domain.models.MTicket;
import de.tjjf.Domain.ports.DB.DataAccess;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.TicketCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Delete.TicketDeleteImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.TicketReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Update.TicketUpdateImpl;
import de.tjjf.Infrastructure.persistence.mapper.TicketMapper;

public class MTicketRepositoryImpl implements DataAccess.MTicketRepository {
    @Override
    public MTicket create(MTicket entity) {
        System.out.println("TESTXYZ");
        //TODO: das problem liegt entweder im mapper oder in ticketCreateImpl => vermutlichn im mapper
        //TODO: nach mapper sind client und employee null?!
        System.out.println("TESTXYZ1.5" + new TicketMapper().toEntity(entity).getClient());
        System.out.println("TESTXYZ1.5" + new TicketMapper().toEntity(entity).getEmployee());
        System.out.println("TESTXYZ2" + new TicketCreateImpl(new TicketMapper().toEntity(entity)).execute());
        return new TicketMapper().toDomain(new TicketCreateImpl(new TicketMapper().toEntity(entity)).execute().model);
    }

    @Override
    public MTicket readById(Long id) {
        return new TicketMapper().toDomain(new TicketReadImpl(id).execute().model);
    }

    @Override
    public void update(MTicket entity) {
        new TicketUpdateImpl(new TicketMapper().toEntity(entity), entity.getTicketId()).execute();
    }

    @Override
    public void delete(Long id) {
        new TicketDeleteImpl(id).execute();
    }
}
