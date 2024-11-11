package de.tjjf.Domain;

public class NoAvailableLuggageWeightException extends RuntimeException {
    public NoAvailableLuggageWeightException( )
    {
    }

    public NoAvailableLuggageWeightException( String message )
    {
        super( message );
    }

    public NoAvailableLuggageWeightException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public NoAvailableLuggageWeightException( Throwable cause )
    {
        super( cause );
    }

    public NoAvailableLuggageWeightException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace )
    {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
