package org.service;

import java.util.List;

import org.dto.Message;

public interface MessageService {

	public Message getMessage(int messageId);

	public int addMessage(Message message);

	public int updateMessage(Message message);

	public int deleteMessage(int messageId);

	public List<Message> getMessages();

}
