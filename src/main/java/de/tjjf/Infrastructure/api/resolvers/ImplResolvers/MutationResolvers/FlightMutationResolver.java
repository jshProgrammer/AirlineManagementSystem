package de.tjjf.Infrastructure.api.resolvers.ImplResolvers.MutationResolvers;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.api.InputModels.FlightInput;
import de.tjjf.Infrastructure.api.resolvers.AbstractResolvers.AbstractMutationResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class FlightMutationResolver extends AbstractMutationResolver<MFlight, FlightInput, Long> {
    @Override
    public MFlight create(FlightInput id) {
        return null;
    }

    @Override
    public MFlight update(FlightInput inputModel) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
