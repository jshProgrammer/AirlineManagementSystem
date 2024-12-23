package de.tjjf.Domain.Exceptions;

public class UnauthorizedException extends RuntimeException {
    private final String errorCode;
    private final String userFriendlyMessage;

    public UnauthorizedException() {
        this.errorCode = "UNAUTHORIZED";
        this.userFriendlyMessage = "Zugriff verweigert. Bitte melden Sie sich an.";
    }

    public UnauthorizedException(String message) {
        super(message);
        this.errorCode = "UNAUTHORIZED";
        this.userFriendlyMessage = "Zugriff verweigert. Bitte melden Sie sich an.";
    }

    public UnauthorizedException(String message, String errorCode, String userFriendlyMessage) {
        super(message);
        this.errorCode = errorCode;
        this.userFriendlyMessage = userFriendlyMessage;
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "UNAUTHORIZED";
        this.userFriendlyMessage = "Zugriff verweigert. Bitte melden Sie sich an.";
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getUserFriendlyMessage() {
        return userFriendlyMessage;
    }
}
