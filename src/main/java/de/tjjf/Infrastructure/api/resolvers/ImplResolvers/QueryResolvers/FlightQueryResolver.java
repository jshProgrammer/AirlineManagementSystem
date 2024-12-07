package de.tjjf.Infrastructure.api.resolvers.ImplResolvers.QueryResolvers;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.api.resolvers.AbstractResolvers.AbstractQueryResolver;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.FlightReadImpl;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.results.ModelResult;
import graphql.kickstart.tools.GraphQLQueryResolver;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FlightQueryResolver extends AbstractQueryResolver<MFlight, Long> {
    @Override
    public MFlight model(Long id) {
        //EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        //TODO: hier darf ich doch jetzt nicht direkt auf persistence zugreifen, sondern muss doch eigentlich den Weg über die Domain gehen oder?

        //FlightReadImpl f = new FlightReadImpl(1);
        //Flight flight = f.run().model;

        return new MFlight(1, null, null, null, null, null, null, null, 3, null, null);
    }

    public MFlight flightByNum(int flightnum ) {
        return new MFlight(1, null, null, null, null, null, null, null, 3, null, null);
    }

    @Override
    public List<MFlight> models() {
        return List.of();
    }

    @Override
    public List<MFlight> modelByName(String name) {
        return List.of();
    }
}
