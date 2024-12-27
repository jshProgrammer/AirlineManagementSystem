package de.tjjf.Infrastructure.api;

import de.tjjf.Infrastructure.Client.CustomGraphQLExceptionHandler;
import de.tjjf.Infrastructure.api.APIExtensions.GraphQlConfig;
import de.tjjf.Infrastructure.api.exceptions.UnauthorizedExceptionHandler;
import de.tjjf.Infrastructure.api.resolvers.*;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import jakarta.servlet.annotation.WebServlet;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "DemoServlet", urlPatterns = "/airlineManagement/*", loadOnStartup = 1)
public class DemoServlet extends GraphQLHttpServlet {
    /*private final UnauthorizedExceptionHandler errorHandler;

    public DemoServlet() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("de.tjjf.Infrastructure.Client"); // Pfad wo dein ErrorHandler liegt
        context.refresh();
        this.errorHandler = context.getBean(UnauthorizedExceptionHandler.class);
    }*/


    @Override
    protected GraphQLConfiguration getConfiguration() {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("de.tjjf.Infrastructure.Client");
        context.refresh();
        CustomGraphQLExceptionHandler customGraphQLExceptionHandler = context.getBean(CustomGraphQLExceptionHandler.class);
*/
        return GraphQLConfiguration.with( createSchema( ) )

                .build( );
    }

    private GraphQLSchema createSchema( ) {
        try
        {
            final String schemaString = IOUtils.toString( this.getClass( )
                    .getResourceAsStream( "/schema.graphqls" ) );

            //TODO: wie müssen wir hier alle Resolver hinzufügen?
            return SchemaParser.newParser( )
                    .schemaString( schemaString )
                    .resolvers( new AirlineResolver(), new AirplaneResolver(), new AirportResolver(), new ClientResolver(), new EmployeeResolver(), new FlightResolver( ), new TicketResolver() )
                    .scalars(new GraphQlConfig().voidScalar(), new GraphQlConfig().dateScalar(), new GraphQlConfig().longScalar())
                    .build( )
                    .makeExecutableSchema( );
        }
        catch ( final IOException e )
        {
            e.printStackTrace( );
            return null;
        }
    }

    /*@Override
    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
                .collect(Collectors.toList());
    }*/


}
