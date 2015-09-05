package org.service;

import java.util.List;

import org.dto.Comment;

public interface CommentService {

	public Comment getComment(int messageID, int commentId);

	public int addComment(Comment comment);

	public int updateComment(Comment comment);

	public int deleteComment(int messageId, int commentId);

	public List<Comment> getComments(int messageID);

}
