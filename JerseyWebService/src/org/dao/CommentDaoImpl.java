package org.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.db.HibernateUtil;
import org.dto.Comment;
import org.hibernate.Query;
import org.hibernate.Session;

public class CommentDaoImpl implements CommentDao {
	private static Logger logger = Logger.getLogger(CommentDaoImpl.class);

	@Override
	public Comment getComment(int messageID, int commentId) {
		String hql = "From Comment where messageid=" + messageID
				+ "and commentID = " + commentId;
		logger.info("getComment for message hql:-" + hql);
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);
		List<Comment> obj_list = query.list();
		if (obj_list.size() > 1) {
			throw new RuntimeException("More Than one Comment found for "
					+ messageID + "," + commentId);
		}

		logger.info("Result :- " + obj_list);
		Comment cmt = null;
		if (obj_list.size() == 1)
			cmt = obj_list.get(0);

		return cmt;
	}

	@Override
	public int addComment(Comment comment) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		s.save(comment);
		s.getTransaction().commit();

		HibernateUtil.closeSession();

		return 0;
	}

	@Override
	public int updateComment(Comment comment) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		s.saveOrUpdate(comment);
		s.getTransaction().commit();

		HibernateUtil.closeSession();
		return 0;
	}

	@Override
	public int deleteComment(int messageId, int commentId) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();

		Query query = s
				.createQuery("delete Comment where commentId = :cmntId and messageID=:msgId");
		query.setParameter("msgId", new Integer(messageId));
		query.setParameter("cmntId", new Integer(commentId));

		int result = query.executeUpdate();

		if (result > 0) {
			logger.info("Expensive Comments  was removed");
		}

		s.getTransaction().commit();

		HibernateUtil.closeSession();
		return 0;

	}

	@Override
	public List<Comment> getComments(int messageID) {
		String hql = "From Comment where messageid=" + messageID;
		HibernateUtil.openSession();
		logger.info("getComments hql:-" + hql);
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);

		List<Comment> obj_list = query.list();
		return obj_list;

	}

}
