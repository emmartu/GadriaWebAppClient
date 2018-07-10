package it.mountaineering.gadria.client.context;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;


public class AppContextListener { //implements ApplicationListener<ApplicationEvent>, ApplicationContextAware {
	private static final java.util.logging.Logger log = Logger.getLogger(AppContextListener.class.getName());
	
	private ApplicationContext applicationContext = null;
	private boolean started = false;
	
	//@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.applicationContext = context;
	}

    //@Override
    //public void onStartup(ServletContext servletContext)   throws ServletException {
    //    //...
    //}

    
    //@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof ContextRefreshedEvent) {
			if(!started) {
				started = true;
				log.info("onApplicationEvent: started");
				//applicationContext.get
				//ClassPathFileResourceLocator.getInstance(applicationContext);
			}
		} else if (event instanceof ContextClosedEvent){

			log.info("onApplicationEvent: stopped");
		}
	}

}
