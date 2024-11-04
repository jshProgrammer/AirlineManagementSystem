package de.tjjf.Domain.ports;


import de.tjjf.Domain.models.MAirline;

import java.util.List;

public interface DataAccess {
    public void createAirline(MAirline airline);

    MAirline read( String name );

    void update( MAirline airline );

    void delete( String name );
}
