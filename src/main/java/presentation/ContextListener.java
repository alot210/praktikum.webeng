package presentation;

import transferobject.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection con = (Connection) sce.getServletContext().getAttribute("connection");

        Configuration.setSQLConnection(con);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
