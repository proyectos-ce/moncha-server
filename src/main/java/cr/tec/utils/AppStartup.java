package cr.tec.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by joseph on 10/26/16.
 */
public class AppStartup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//Context destroyed code here
	}


	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent)
	{
		Database.configure();
		System.out.println("Programa inicializado");
	}

}
