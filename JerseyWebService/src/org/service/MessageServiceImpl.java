package org.service;

import java.util.List;

import org.dao.MessageDao;
import org.dao.MessageDaoImpl;
import org.dto.Message;
import org.exception.DataNotFoundException;

public class MessageServiceImpl implements MessageService {

	private MessageDao MessageDao;

	public MessageServiceImpl() {
		super();
		MessageDao = new MessageDaoImpl();
	}

	@Override
	public Message getMessage(int messageId) {
		Message msg = MessageDao.getMessage(messageId);
		if (msg == null)
			throw new DataNotFoundException("No Message found for id "
					+ messageId);
		return msg;
	}

	@Override
	public int addMessage(Message message) {

		return MessageDao.addMessage(message);
	}

	@Override
	public int updateMessage(Message message) {

		return MessageDao.updateMessage(message);
	}

	@Override
	public int deleteMessage(int messageId) {

		return MessageDao.deleteMessage(messageId);
	}

	@Override
	public List<Message> getMessages() {

		return MessageDao.getMessages();
	}

}
