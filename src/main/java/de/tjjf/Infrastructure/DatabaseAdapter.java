package de.tjjf.Infrastructure;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.ports.DataAccess;
import de.tjjf.Infrastructure.mapper.AirlineMapper;
import de.tjjf.Infrastructure.models.Airline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class DatabaseAdapter implements DataAccess {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "my-persistence-unit" );

    //TODO: in test case umwandeln
    public static void main(String[] args) {
        DatabaseAdapter db = new DatabaseAdapter();
        MAirline mairline = new MAirline("Eurowings Discover", new Date(1990), "München");
        db.createAirline(mairline);

        System.out.println(" - - - - - ");

        MAirline a = db.read("Eurowings Discover");
        System.out.println(a.getHeadQuarters());

        System.out.println(" - - - - - ");

        mairline.setHeadQuarters("Würzburg");
        db.update(mairline);

        System.out.println(" - - - - - ");

        a = db.read("Eurowings Discover");
        System.out.println(a.getHeadQuarters());

        System.out.println(" - - - - - ");

        db.delete(mairline.getName());

        // für test case NullPointerException abfragen
        //a = db.read("Eurowings Discover");
        //System.out.println(a.getHeadQuarters());

    }

    @Override
    public void createAirline(MAirline airline) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            em.getTransaction( ).begin( );
            em.persist(AirlineMapper.toEntity(airline));
            em.getTransaction( ).commit( );
        }
        catch ( Exception e )
        {
            if ( em != null && em.getTransaction( ).isActive( ) )
            {
                em.getTransaction( ).rollback( );
            }
            throw new DataAccessException( "Error while saving airline entity", e );
        }
        finally
        {
            if ( em != null )
            {
                em.close( );
            }
        }
    }

    @Override
    public MAirline read(String name) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            final Airline result = em.find( Airline.class, name );
            return AirlineMapper.toDomain(result);
        }
        catch ( Exception e )
        {
            throw new DataAccessException( "Error while reading airline entity", e );
        }
    }

    @Override
    public void update(MAirline airline) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            em.getTransaction( ).begin( );
            em.merge( AirlineMapper.toEntity(airline) );
            em.getTransaction( ).commit( );
        }
        catch ( Exception e )
        {
            if ( em.getTransaction( ).isActive( ) )
            {
                em.getTransaction( ).rollback( );
            }
            throw new DataAccessException( "Error while updating airline entity", e );
        }
        finally
        {
            if ( em != null )
            {
                em.close( );
            }
        }
    }

    @Override
    public void delete(String name) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            em.getTransaction( ).begin( );
            final Airline result = em.find( Airline.class, name);
            if ( result != null )
            {
                em.remove( result );
            }
            em.getTransaction( ).commit( );
        }
        catch ( Exception e )
        {
            throw new DataAccessException( "Error while deleting airline entity", e );
        }
    }
}
