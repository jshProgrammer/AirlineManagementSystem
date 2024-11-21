package de.tjjf.Domain.ports;


import de.tjjf.Domain.models.*;

//TODO: wofür brauchen wir den noch?!

public interface DataAccess {
    public void create(MModel mModel);


    void update( MModel mModel );


}
