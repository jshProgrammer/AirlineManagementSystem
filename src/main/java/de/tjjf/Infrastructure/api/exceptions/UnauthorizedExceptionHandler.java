package de.tjjf.Infrastructure.api.exceptions;

import de.tjjf.Domain.Exceptions.UnauthorizedException;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import graphql.schema.DataFetchingEnvironment;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
@Component
public class UnauthorizedExceptionHandler implements GraphQLErrorHandler {


    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return GraphQLErrorHandler.super.errorsPresent(errors);
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream()
                .map(this::processError)
                .collect(Collectors.toList());
    }

    private GraphQLError processError(GraphQLError error) {
        if (error instanceof UnauthorizedException exceptionError) {

            return convertToGraphQLError(exceptionError);

        }
        return error;
    }

    private GraphQLError convertToGraphQLError(UnauthorizedException error) {

        return new CustomGraphQLError(
                error.getMessage(),
                null,//error.getLocations(),
                null,//error.get(),
                Map.of(
                        "code", "UnauthorizedException",
                        "domainErrorCode", 401
                )
        );


    }


}
*/