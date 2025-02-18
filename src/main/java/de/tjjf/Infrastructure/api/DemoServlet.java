package de.tjjf.Infrastructure.api;

import de.tjjf.Infrastructure.api.APIExtensions.GraphQlConfig;

import de.tjjf.Infrastructure.api.resolvers.*;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import jakarta.servlet.annotation.WebServlet;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

@WebServlet(name = "DemoServlet", urlPatterns = "/airlineManagement/*", loadOnStartup = 1)
public class DemoServlet extends GraphQLHttpServlet {


    @Override
    protected GraphQLConfiguration getConfiguration() {

        return GraphQLConfiguration.with( createSchema( ) )
                .build( );
    }

    private GraphQLSchema createSchema( ) {
        try
        {
            final String schemaString = IOUtils.toString( this.getClass( )
                    .getResourceAsStream( "/schema.graphqls" ) );

            return SchemaParser.newParser( )
                    .schemaString( schemaString )
                    .resolvers( new AirlineResolver(), new AirplaneResolver(), new AirportResolver(), new ClientResolver(), new EmployeeResolver(), new FlightResolver( ), new TicketResolver() )
                    .scalars(new GraphQlConfig().voidScalar(), new GraphQlConfig().longScalar())
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
