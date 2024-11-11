package de.tjjf.Domain;

public class NoSeatsLeftException extends RuntimeException {
    public NoSeatsLeftException( )
    {
    }

    public NoSeatsLeftException( String message )
    {
        super( message );
    }

    public NoSeatsLeftException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public NoSeatsLeftException( Throwable cause )
    {
        super( cause );
    }

    public NoSeatsLeftException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace )
    {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
