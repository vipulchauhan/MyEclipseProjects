package org.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.dto.Comment;
import org.dto.Message;
import org.service.CommentService;
import org.service.CommentServiceImpl;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentServiceImpl();
	private static Logger logger = Logger.getLogger(CommentResource.class);

	@GET
	public List<Comment> getComments(@PathParam("messageID") Integer id) {
		logger.info("\n------USER----------");
		logger.info("getComments request received for message id " + id);
		logger.info("\n------USER-END----------");
		List<Comment> comment_list = null;

		comment_list = commentService.getComments(id);

		return comment_list;
	}

	@GET
	@Path("{commentId}")
	public Comment getComment(@PathParam("messageID") Integer id,
			@PathParam("commentId") Integer cid) {
		logger.info("\n------USER----------");
		logger.info("getComments request received for message id " + id
				+ "commentid " + cid);
		logger.info("\n------USER-END----------");

		Comment cmnt = commentService.getComment(id, cid);

		return cmnt;
	}

	@POST
	public Comment addComment(@PathParam("messageID") Integer id,
			Comment comment) {
		Message msg = new Message();
		msg.setMessageID(id);
		comment.setMessage(msg);
		logger.info("\n------USER----------");
		logger.info("addComment request received :- " + comment);

		Integer i = commentService.addComment(comment);
		logger.info("addComment request responce :- " + i);
		logger.info("\n------USER-END----------");
		return comment;
	}

	@PUT
	@Path("/{commentID}")
	public Comment updateComment(@PathParam("messageID") Integer id,
			@PathParam("commentID") int cid, Comment comment) {
		Message msg = new Message();
		msg.setMessageID(id);
		comment.setMessage(msg);
		comment.setCommentId(cid);
		logger.info("\n------USER----------");
		logger.info("updateComment request received :- " + comment);

		Integer i = commentService.updateComment(comment);
		logger.info("updateComment request responce :- " + i);
		logger.info("\n------USER-END----------");
		return comment;
	}

	@DELETE
	@Path("/{commentID}")
	public void deleteComment(@PathParam("messageID") Integer id,
			@PathParam("commentID") int cid) {

		logger.info("\n------USER----------");
		logger.info("deleteComment request received");
		logger.info("\n------USER-END----------");
		commentService.deleteComment(id, cid);

	}
}
