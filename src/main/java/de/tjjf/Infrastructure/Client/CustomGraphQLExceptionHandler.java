package de.tjjf.Infrastructure.Client;

import de.tjjf.Domain.Exceptions.UnauthorizedException;
import graphql.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class CustomGraphQLExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public GraphQLError handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        System.out.println("UnauthorizedException recognized");
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.ValidationError)
                .extensions(Map.of(
                        "code", "UNAUTHORIZED",
                        "classification", "AuthenticationError"
                ))
                .build();
    }
}