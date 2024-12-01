package de.tjjf.Infrastructure.api.resolvers.AbstractResolvers;

import de.tjjf.Domain.models.MModel;
import de.tjjf.Infrastructure.api.InputModels.MModelInput;
import graphql.kickstart.tools.GraphQLMutationResolver;

// I for Identifer, e.g. long or Stirng
public abstract class AbstractMutationResolver<M extends MModel, T extends MModelInput, I> implements GraphQLMutationResolver {
    public abstract M create(final T id);

    public abstract M update(final T inputModel);

    public abstract boolean delete(I id);
}
