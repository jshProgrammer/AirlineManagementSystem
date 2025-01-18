package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.UnauthorizedException;

//10.01.2025: Gespräch mit Prof. Dr. Braun: Authorization nicht notwendig da Error Weitergabe von Resolver zu Client in GraphQL kaum umsetzbar
public abstract class AuthorizedUseCase {
    private final AuthenticationUseCase authenticationUseCase;

    public AuthorizedUseCase(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    public void authorize() throws UnauthorizedException {
        if (!authenticationUseCase.isAuthorized()) {
            throw new UnauthorizedException("User is not authorized to perform this action.");
        }
    }
}