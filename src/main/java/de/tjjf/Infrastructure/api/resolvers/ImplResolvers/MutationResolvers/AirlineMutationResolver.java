package de.tjjf.Infrastructure.api.resolvers.ImplResolvers.MutationResolvers;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.models.MModel;
import de.tjjf.Infrastructure.api.InputModels.AirlineInput;
import de.tjjf.Infrastructure.api.InputModels.MModelInput;
import de.tjjf.Infrastructure.api.resolvers.AbstractResolvers.AbstractMutationResolver;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AirlineMutationResolver extends AbstractMutationResolver<MAirline, AirlineInput, String> {
        @Override
    public MAirline create(AirlineInput id) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        //TODO: hier darf ich doch jetzt nicht direkt auf persistence zugreifen, sondern muss doch eigentlich den Weg über die Domain gehen oder?
        return null;
    }

    @Override
    public MAirline update(AirlineInput inputModel) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
