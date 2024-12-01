package de.tjjf.Infrastructure.api;

import de.tjjf.Infrastructure.api.resolvers.ImplResolvers.MutationResolvers.FlightMutationResolver;
import de.tjjf.Infrastructure.api.resolvers.ImplResolvers.QueryResolvers.FlightQueryResolver;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class DemoServlet extends GraphQLHttpServlet {
    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration.with( createSchema( ) ).build( );
    }

    private GraphQLSchema createSchema( ) {
        try
        {
            final String schemaString = IOUtils.toString( this.getClass( )
                    .getResourceAsStream( "/schema.graphqls" ) );

            //TODO: wie müssen wir hier alle Resolver hinzufügen?
            return SchemaParser.newParser( )
                    .schemaString( schemaString )
                    .resolvers( new FlightQueryResolver( ), new FlightMutationResolver( ) )
                    .build( )
                    .makeExecutableSchema( );
        }
        catch ( final IOException e )
        {
            e.printStackTrace( );
            return null;
        }
    }


}
