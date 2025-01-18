package de.tjjf.Infrastructure.GraphQLClient.results;

import de.tjjf.Infrastructure.api.models.APIModel;

public class ModelResult<T extends APIModel> extends AbstractResult {

    public T model;

    public ModelResult(T model) {
        this.model = model;
    }
}
