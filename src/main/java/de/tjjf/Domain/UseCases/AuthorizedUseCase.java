package de.tjjf.Domain.UseCases;

import de.tjjf.Domain.Exceptions.UnauthorizedException;

//TODO: alle UseCases von dieser Klasse erben lassen und die authorize Methode aufrufen
public abstract class AuthorizedUseCase {
    private final AuthenticationUseCase authenticationUseCase;

    public AuthorizedUseCase(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    protected void authorize() throws UnauthorizedException {
        if (!authenticationUseCase.isAuthorized()) {
            throw new UnauthorizedException("User is not authorized to perform this action.");
        }
    }
}