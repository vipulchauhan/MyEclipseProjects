package org.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

@Path("/test")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// @Produces(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public class TestResource {
	private static Logger logger = Logger.getLogger(ProfileResource.class);

	@GET
	public String testMethod(@MatrixParam("matParam") String matval,
			@HeaderParam("myHeaderParam") String headerParamVal,
			@CookieParam("myCookieParam") String cookieParamVal) {
		Map<String, String> myMap = new HashMap<>();
		List<String> myList = new ArrayList<String>();
		logger.info("Request received");
		logger.info("Matrix Param :-" + matval);
		logger.info("Header Param :-" + headerParamVal);
		logger.info("Cookie Param :-" + cookieParamVal);
		myMap.put("Matrix Param", matval);
		myMap.put("Custom Header Param", headerParamVal);
		myMap.put("Custom Cookie Param", cookieParamVal);
		myList.add(matval);
		myList.add(headerParamVal);
		myList.add(cookieParamVal);
		logger.info("Result Map" + myMap);
		logger.info("Result List" + myList);
		return myMap.toString();
	}

	@GET
	@Path("/context")
	public String testContext(@Context UriInfo uriInfo,
			@Context HttpHeaders httpHeader) {
		String str = "";
		logger.info("Context Request received");
		logger.info("Matrix Param :-" + uriInfo.toString());
		logger.info("Header Param :-" + httpHeader.toString());
		str = "URL:-" + uriInfo.getAbsolutePath() + " , " + " httpHeader:- "
				+ httpHeader.getLength();

		return str;
	}
}
