package org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String commentText;
	@ManyToOne
	@XmlTransient
	@JoinColumn(name = "messageID")
	private Message message;
	private int likes;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes() {
		this.likes++;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText="
				+ commentText + ", message=" + message + ", likes=" + likes
				+ "]";
	}

}
