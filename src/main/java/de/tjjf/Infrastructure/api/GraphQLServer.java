package de.tjjf.Infrastructure.api;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQLServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        context.setContextPath( "/" );
        server.setHandler( context );

        context.addServlet( new ServletHolder( new DemoServlet( ) ), "/airlineManagement" );

        server.start( );

        server.join( );
    }
}
