package de.tjjf.Infrastructure.Client;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.kickstart.execution.error.GenericGraphQLError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream()
                .map(this::getCustomError)
                .collect(Collectors.toList());
    }

    private GraphQLError getCustomError(GraphQLError error) {
        System.out.println("geht hier rein" + error.getMessage());
        if (error.getMessage().contains("UnauthorizedException")) {
            return new GenericGraphQLError("User is not authorized to perform this action.");
        }
        return error;
    }
}