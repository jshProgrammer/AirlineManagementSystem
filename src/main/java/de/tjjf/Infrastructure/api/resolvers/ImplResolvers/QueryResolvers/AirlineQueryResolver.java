package de.tjjf.Infrastructure.api.resolvers.ImplResolvers.QueryResolvers;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.api.resolvers.AbstractResolvers.AbstractQueryResolver;

import java.util.List;

public class AirlineQueryResolver {

    public MAirline airlineByName(String name) {
        return new MAirline("Test", null, "TestStadt", null, null, null);
    }


    public List<MAirline> airlines() {
        return List.of(new MAirline("Test", null, "TestStadt", null, null, null));
    }
}
