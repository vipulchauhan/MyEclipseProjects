package org.listners;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

public class JAXRSRequestEventListners implements RequestEventListener {
	private final int requestNumber;
	private final long startTime;
	static Logger logger = Logger.getLogger(JAXRSRequestEventListners.class);

	public JAXRSRequestEventListners(int requestNumber) {
		this.requestNumber = requestNumber;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void onEvent(RequestEvent event) {
		logger.info(event.getType() + " occuered");
		switch (event.getType()) {
		case RESOURCE_METHOD_START:
			logger.info("Resource method "
					+ event.getUriInfo().getMatchedResourceMethod()
							.getHttpMethod() + " started for request "
					+ requestNumber);
			break;
		case FINISHED:
			logger.info("Request " + requestNumber
					+ " finished. Processing time "
					+ (System.currentTimeMillis() - startTime) + " ms.");
			break;
		}
	}
}
