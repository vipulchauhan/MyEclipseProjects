package org.dao;

import java.io.Serializable;
import java.util.List;

import org.db.HibernateUtil;
import org.dto.Message;
import org.hibernate.Session;

public class MessageDaoImpl implements MessageDao {

	@Override
	public Message getMessage(int messageId) {
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();

		Message message = new Message();
		message = (Message) session.get(Message.class, messageId);
		HibernateUtil.closeSession();
		return message;
	}

	@Override
	public int addMessage(Message message) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();

		s.beginTransaction();
		s.save(message);

		s.getTransaction().commit();
		Serializable id = s.getIdentifier(message);
		HibernateUtil.closeSession();

		return (Integer) id;
	}

	@Override
	public int updateMessage(Message message) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		s.saveOrUpdate(message);
		s.getTransaction().commit();

		HibernateUtil.closeSession();
		return 0;
	}

	@Override
	public int deleteMessage(int messageId) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Message message = (Message) s.load(Message.class, messageId);
		s.delete(message);
		s.getTransaction().commit();

		HibernateUtil.closeSession();
		return 0;
	}

	@Override
	public List<Message> getMessages() {
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();
		List<Message> messageList = session.createQuery(
				"from Message order by messageID").list();
		HibernateUtil.closeSession();
		return messageList;
	}

}
