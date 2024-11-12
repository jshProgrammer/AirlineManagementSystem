package de.tjjf.Infrastructure.persistence.DBOperations;

import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.entities.Airplane;

import java.util.Date;

public class DBAirplaneImpl extends DBOperationTemplate{
    Airplane a;

    public DBAirplaneImpl(Airplane a) {
        this.a = a;
    }

    @Override
    public void create() {
        this.em.persist(a);
    }

    //TODO: wie bekommen wir hier ein Paramter in die Methode + wie was zurück geben, weil ja eig void Rückgabetyp bei execute
    // => Idee: rückgabe von find-Methode als Attribut speichern und darauf zugreifen?
    @Override
    public void read() {
       // result = em.find( model, name );
    }


    public void update() {
        this.em.merge(this.a);
    }

    @Override
    public void delete() {

    }

    public static void main(String[] args) {
        Airline airline = new Airline("Our Airline", new Date(2024), "München");
        DBAirlineImpl dbAirline = new DBAirlineImpl(airline);
        dbAirline.execute(CRUD.Create);


        DBAirplaneImpl dbAirplane = new DBAirplaneImpl(new Airplane(123, "Boeing", "kp",30, 40, 10, airline , true));
        dbAirplane.execute(CRUD.Create);

    }
}
