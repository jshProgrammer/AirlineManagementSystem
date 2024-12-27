package de.tjjf.Infrastructure.api.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class CustomGraphQLError implements GraphQLError {
    private final String message;
    private final List<SourceLocation> locations;
    private final List<Object> path;
    private final Map<String, Object> extensions;

    public CustomGraphQLError(String message, List<SourceLocation> locations, List<Object> path, Map<String, Object> extensions) {
        this.message = message;
        this.locations = locations;
        this.path = path;
        this.extensions = extensions;
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return List.of();
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return GraphQLError.super.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return GraphQLError.super.toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return GraphQLError.super.getExtensions();
    }
}

