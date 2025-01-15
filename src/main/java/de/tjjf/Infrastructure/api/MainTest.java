package de.tjjf.Infrastructure.api;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        context.setContextPath( "/" );
        server.setHandler( context );

        // change path if graphql server should have another URI
        context.addServlet( new ServletHolder( new DemoServlet( ) ), "/airlineManagement" );

        server.start( );

        // The next statement keeps the server running -- don't remove it!
        server.join( );
    }
}
