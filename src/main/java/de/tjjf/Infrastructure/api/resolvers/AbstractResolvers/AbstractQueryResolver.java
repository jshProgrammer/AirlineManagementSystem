package de.tjjf.Infrastructure.api.resolvers.AbstractResolvers;

import de.tjjf.Domain.models.MModel;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

//TODO: hier Verallgemeinerung (nur für Query) nicht sinnvoll oder
// I for identifier => string or long
public abstract class AbstractQueryResolver<T extends MModel, I> implements GraphQLQueryResolver {
    public abstract T model(final I id);
    public abstract List<T> models();
    //TODO: kann man das wirklich verallgemeinern? manche wie Airline haben Namen ja schon als Id?!
    public abstract List<T> modelByName(String name);
}
