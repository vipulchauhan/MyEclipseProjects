package org.service;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.dao.CommentDao;
import org.dao.CommentDaoImpl;
import org.dto.Comment;
import org.dto.ErrorMessage;

public class CommentServiceImpl implements CommentService {

	private CommentDao CommentDao;
	private static Logger logger = Logger.getLogger(CommentServiceImpl.class);

	public CommentServiceImpl() {
		super();
		CommentDao = new CommentDaoImpl();
	}

	@Override
	public Comment getComment(int messageID, int commentId) {
		logger.fatal("Message id :-" + messageID);
		if (messageID == 0) {

			ErrorMessage errorMessage = new ErrorMessage(
					Status.NOT_FOUND.getStatusCode(), "Message Id is null", "");
			Response res = Response.status(Status.NOT_FOUND)
					.entity(errorMessage).build();

			logger.fatal("Message id is null or Zero");
			//throw new WebApplicationException(res);
			throw new NotFoundException(res);
		}

		return CommentDao.getComment(messageID, commentId);
	}

	@Override
	public int addComment(Comment comment) {

		return CommentDao.addComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {

		return CommentDao.updateComment(comment);
	}

	@Override
	public int deleteComment(int messageId, int commentId) {

		return CommentDao.deleteComment(messageId, commentId);
	}

	@Override
	public List<Comment> getComments(int messageID) {

		return CommentDao.getComments(messageID);
	}

}
