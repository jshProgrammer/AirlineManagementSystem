package de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read;

import de.tjjf.Infrastructure.persistence.DBOperations.AbstractOperations.AbstractReadOperation;
import de.tjjf.Infrastructure.persistence.EntityManagerFactorySingleton;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import java.util.List;

public class FlightReadImpl extends AbstractReadOperation<Flight, Long> {
    public FlightReadImpl(long identifier){
        super(Flight.class, identifier);
    }

    public FlightReadImpl() {
        super(Flight.class, null);
    }

    public List<Flight> getAllFlights(int pageNumber, int pageSize) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f", Flight.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
