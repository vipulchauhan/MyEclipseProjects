package org.exception;

import java.util.Arrays;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.dto.ErrorMessage;


public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	private static Logger logger = Logger
			.getLogger(GenericExceptionMapper.class);

	@Override
	public Response toResponse(Throwable err) {
		System.out.println("GenericExceptionMapper");
		ErrorMessage errorMessage = new ErrorMessage(
				Status.NOT_FOUND.getStatusCode(), err.getMessage(),
				Arrays.toString(err.getStackTrace()));
		logger.fatal("GenericExceptionMapper Mappaer Called :-" + errorMessage);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
