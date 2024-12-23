package de.tjjf.Infrastructure.api;

public class GraphQLUnauthorizedException extends RuntimeException {
    public GraphQLUnauthorizedException(String message) {
        super(message);
    }
}
