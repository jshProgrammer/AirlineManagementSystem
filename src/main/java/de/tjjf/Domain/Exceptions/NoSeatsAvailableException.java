package de.tjjf.Domain.Exceptions;

public class NoSeatsAvailableException extends RuntimeException {
    public NoSeatsAvailableException( )
    {
    }

    public NoSeatsAvailableException(String message )
    {
        super( message );
    }

    public NoSeatsAvailableException(String message, Throwable cause )
    {
        super( message, cause );
    }

    public NoSeatsAvailableException(Throwable cause )
    {
        super( cause );
    }

    public NoSeatsAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace )
    {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
