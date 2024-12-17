package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.persistence.entities.Airplane;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class AirplaneResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public void createAirplane(Airplane airplane) {}
}
