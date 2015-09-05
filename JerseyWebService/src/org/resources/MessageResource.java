package org.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.dto.Links;
import org.dto.Message;
import org.service.MessageService;
import org.service.MessageServiceImpl;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
// @Produces(MediaType.TEXT_PLAIN)
// @Produces(MediaType.APPLICATION_XML)
public class MessageResource {

	private MessageService messageService = new MessageServiceImpl();
	static Logger logger = Logger.getLogger(MessageResource.class);

	@GET
	public List<Message> getMessages() {
		logger.info("\n------USER----------");
		logger.info("getMessages request received");
		logger.info("\n------USER-END----------");

		return messageService.getMessages();
	}

	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") int id,
			@Context UriInfo uriInfo) {
		logger.info("\n------USER----------");
		logger.info("getMessage request received for id " + id);

		Message message = messageService.getMessage(id);
		message.addLink(selfRelationUrl(id, uriInfo), "self");
		message.addLink(profileRelationUrl(message, uriInfo), "profile");
		message.addLink(commentsRelationUrl(message, uriInfo), "comments");

		logger.info("getMessage response received for id " + message);
		logger.info("\n------USER-END----------");
		return message;
	}

	private String commentsRelationUrl(Message message, UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageID", message.getMessageID()).build()
				.toString();

		return url;
	}

	private String profileRelationUrl(Message message, UriInfo uriInfo) {
		return uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(message.getProfile().getProfileUser()).build().toString();
	}

	private String selfRelationUrl(int id, UriInfo uriInfo) {
		return uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Integer.toString(id)).build()
				.toString();
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo)
			throws URISyntaxException {

		logger.info("\n------USER----------");
		logger.info("addMessage request received :- " + message);

		Integer i = messageService.addMessage(message);

		URI uri = uriInfo.getAbsolutePathBuilder().path(i.toString()).build();
		logger.info("addMessage request responce :- " + i + " at uri " + uri);
		logger.info("\n------USER-END----------");
		// Response.status(Status.CREATED)
		return Response.created(uri).entity(message).build();
	}

	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") int id, Message message) {

		logger.info("\n------USER----------");
		logger.info("updateMessage request received :- " + message);
		message.setMessageID(id);
		Integer i = messageService.updateMessage(message);
		logger.info("updateMessage request responce :- " + i);
		logger.info("\n------USER-END----------");
		return message;
	}

	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") int id) {
		logger.info("\n------USER----------");
		logger.info("deleteMessage request received");
		logger.info("\n------USER-END----------");
		messageService.deleteMessage(id);

	}

	@Path("/{messageID}/comments")
	public CommentResource getCommentResource() {
		logger.info("\n------USER----------");
		logger.info("Comments request received");
		logger.info("\n------USER-END----------");

		return new CommentResource();
	}
}
