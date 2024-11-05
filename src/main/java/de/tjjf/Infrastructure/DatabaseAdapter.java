package de.tjjf.Infrastructure;

import de.tjjf.Domain.models.*;
import de.tjjf.Domain.ports.DataAccess;
import de.tjjf.Infrastructure.mapper.*;
import de.tjjf.Infrastructure.models.*;
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
        db.create(mairline);

        MAirline mAirline = new MAirline("AirlineName", new Date(1995), "Headquarters");
        db.create(mAirline);

        MAirplane airplane = new MAirplane(12345,
                "Boeing", "737",150, 30, 10, mAirline,  true );
        db.create(airplane);

        System.out.println(" - - - - - ");

        MAirline a = db.readAirline ("Eurowings Discover");
        System.out.println(a.getHeadQuarters());

        System.out.println(" - - - - - ");

        MAirplane pl = db.readAirplane(12345);
        System.out.println(pl.getManufacturer());
        System.out.println(" - - - - - ");

        mairline.setHeadQuarters("Würzburg");
        db.update(mairline);

        System.out.println(" - - - - - ");

        //a = db.read("Eurowings Discover");
        //System.out.println(a.getHeadQuarters());

        System.out.println(" - - - - - ");

        //db.deleteAirplane(12345);
        // für test case NullPointerException abfragen, wenn vorherige Zeile nicht mehr kommentiert
        db.readAirplane(12345);

    }

    public void create(MModel mModel) {
        Mapper mapper = switch(mModel) {
            case MAirline mAirline -> new AirlineMapper();
            case MAirplane mAirplane -> new AirplaneMapper();
            case MAirport mAirport -> new AirportMapper();
            case MPerson mPerson -> new PersonMapper();
            //case MBooking mBooking -> new BookingMapper();
            //case MClient mClient -> new ClientMapper();
            //case MEmployee mEmployee -> new EmployeeMapper();
            //case MFlight mFlight -> new FlightMapper();
            default -> throw new DataAccessException("No entity of this type existing");
        };

        create(mModel, mapper);
    }

    private void create(MModel mModel, Mapper mapper) {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(mapper.toEntity(mModel));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DataAccessException("Error while saving airline entity", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public MAirline readAirline(String name) {
        return  (MAirline) read(Airline.class, name, new AirlineMapper());
    }
    public MAirplane readAirplane(int serialnumber) {
        return  (MAirplane) read(Airplane.class, serialnumber, new AirplaneMapper());
    }
    public MAirport readAirport(String code) {
        return  (MAirport) read(Airport.class, code, new AirportMapper());
    }
    public MBooking readBooking(int bookingnum) {
        return  (MBooking) read(Booking.class, bookingnum, new AirlineMapper());
    }
     /*public MClient readClient(int personId) {
        return (MClient) read(Client.class, personId, new ClientMapper());
    }*/
    /*public MEmployee readEmployee(int employeeid) {
        return (MEmployee) read(Employee.class, employeeid, new EmployeeMapper());
    }*/
    /*public MFlight readFlight(long flightnum) {
        return  (MFlight) read(Flight.class, flightnum, new FlightMapper());
    }*/

    public MPerson readPerson(int personId) {
        return  (MPerson) read(Person.class, personId, new PersonMapper());
    }


    private MModel read(Class<? extends Model> model, Object name, Mapper mapper) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            final Model result = em.find( model, name );
            return mapper.toDomain(result);
        }
        catch ( Exception e )
        {
            throw new DataAccessException( "Error while reading entity", e );
        }
    }

    public void update(MModel mModel) {
        Mapper mapper = switch(mModel) {
            case MAirline mAirline -> new AirlineMapper();
            case MAirplane mAirplane -> new AirplaneMapper();
            case MAirport mAirport -> new AirportMapper();
            case MPerson mPerson -> new PersonMapper();
            //case MBooking mBooking -> new BookingMapper();
            //case MClient mClient -> new ClientMapper();
            //case MEmployee mEmployee -> new EmployeeMapper();
            //case MFlight mFlight -> new FlightMapper();
            default -> throw new DataAccessException("No entity of this type existing");
        };

        update(mModel, mapper);
    }

    @Override
    public void update(MAirline airline) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            em.getTransaction( ).begin( );
            em.merge( mapper.toEntity(mModel) );
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

    public void deleteAirline(String name){
        delete(Airline.class, name, new AirlineMapper());
    }

    public void deleteAirplane(int serialnumber) {
        delete(Airplane.class, serialnumber, new AirplaneMapper());
    }
    public void deleteAirport(String code) {
        delete(Airport.class, code, new AirportMapper());
    }
    public void deleteBooking(int bookingnum) {
        delete(Booking.class, bookingnum, new AirlineMapper());
    }


    /*public void delteClient(int personId){
        delete(Client.class, personId, new ClientMapper());
    }*/

    /*public void deleteEmployee(int employeeId){
        delete(Employee.class, employeeId, new EmployeeManager());
    }*/

    /*public void deleteFlight(long flightnum){
        delete(Flight.class, flightnum, new FlightMapper());
    }*/

    public void deletePerson(int personId) {
        delete(Person.class, personId, new PersonMapper());
    }


    private void delete(Class<? extends Model> model, Object name, Mapper mapper) {
        EntityManager em = null;

        try
        {
            em = emf.createEntityManager( );
            em.getTransaction( ).begin( );
            final Model result = em.find( model, name);
            if ( result != null )
            {
                em.remove( result );
            }
            em.getTransaction( ).commit( );
        }
        catch ( Exception e )
        {
            throw new DataAccessException( "Error while deleting entity", e );
        }
    }
}
