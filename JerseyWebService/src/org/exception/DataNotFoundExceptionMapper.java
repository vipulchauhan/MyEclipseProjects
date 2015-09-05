package org.exception;

import java.util.Arrays;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;
import org.dto.ErrorMessage;

public class DataNotFoundExceptionMapper implements
		ExceptionMapper<DataNotFoundException> {
	private static Logger logger = Logger
			.getLogger(DataNotFoundExceptionMapper.class);

	@Override
	public Response toResponse(DataNotFoundException err) {
		System.out.println("DataNotFoundExceptionMapper");

		ErrorMessage errorMessage = new ErrorMessage(
				Status.NOT_FOUND.getStatusCode(), err.getMessage(),
				Arrays.toString(err.getStackTrace()));
		logger.fatal("DataNotFoundExceptionMapper Mappaer Called :-"
				+ errorMessage);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
