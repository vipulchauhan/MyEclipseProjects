package org.listners;

import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

@Provider
public class JAXRSApplicationEventListners implements ApplicationEventListener {
	static Logger logger = Logger
			.getLogger(JAXRSApplicationEventListners.class);
	private volatile int requestCnt = 0;

	@Override
	public void onEvent(ApplicationEvent event) {
		logger.info(event.getType() + " occuered");
		switch (event.getType()) {
		case INITIALIZATION_FINISHED:
			logger.info("Application "
					+ event.getResourceConfig().getApplicationName()
					+ " was initialized.");
			break;
		case DESTROY_FINISHED:
			logger.info("Application "
					+ event.getResourceConfig().getApplicationName()
					+ " destroyed.");
			break;
		}

	}

	@Override
	public RequestEventListener onRequest(RequestEvent arg0) {
		requestCnt++;
		logger.info("Request " + requestCnt + " started.");
		// return the listener instance that will handle this request.
		return new JAXRSRequestEventListners(requestCnt);

	}

}
