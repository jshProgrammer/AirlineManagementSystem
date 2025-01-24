package de.tjjf.Infrastructure.api;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class GraphQLServer {
    public static void main(String[] args) throws Exception {
        int port = args[0] != null ? Integer.parseInt(args[0]) : 8081;
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        context.setContextPath( "/" );
        server.setHandler( context );

        context.addServlet( new ServletHolder( new DemoServlet( ) ), "/airlineManagement" );

        server.start( );

        server.join( );
    }
}
