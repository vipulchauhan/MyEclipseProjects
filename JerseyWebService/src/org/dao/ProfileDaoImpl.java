package org.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.db.HibernateUtil;
import org.dto.Profile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProfileDaoImpl implements ProfileDao {
	private static Logger logger = Logger.getLogger(ProfileDaoImpl.class);

	@Override
	public Profile getProfile(String profileUser) {
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();
		Criteria criteria = HibernateUtil.getSession().createCriteria(
				Profile.class);
		criteria.add(Restrictions.eq("profileUser", profileUser)); // and
		List<Profile> prfl_list = criteria.list();
		if (prfl_list.size() > 1) {
			throw new RuntimeException("More Than one profile found for "
					+ profileUser);
		}
		Profile profile = null;
		logger.info("Criteria :- " + profileUser);
		logger.info("Result :- " + prfl_list);

		if (prfl_list.size() == 1)
			profile = prfl_list.get(0);

		HibernateUtil.closeSession();
		return profile;
	}

	@Override
	public int addProfile(Profile profile) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		profile.setCreateDate(new Date());
		s.beginTransaction();
		s.save(profile);
		s.getTransaction().commit();

		HibernateUtil.closeSession();

		return 0;
	}

	@Override
	public int updateProfile(Profile profile) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		s.save(profile);
		s.getTransaction().commit();
		return 0;
	}

	@Override
	public int deleteProfile(int profileId) {
		HibernateUtil.openSession();
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Profile profile = (Profile) s.load(Profile.class, profileId);
		s.delete(profile);
		s.getTransaction().commit();

		HibernateUtil.closeSession();
		return 0;
	}

	@Override
	public List<Profile> getProfiles() {
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();
		List<Profile> profileList = session.createQuery(
				"from Profile order by profileID").list();
		HibernateUtil.closeSession();
		return profileList;
	}

	@Override
	public List<Profile> getProfileByYear(int year) {
		String hql = "From Profile where year(createDate)=" + year;
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);
		// query.setFirstResult(5);
		// query.setMaxResults(8);
		List<Profile> obj_list = query.list();
		return obj_list;

	}

	@Override
	public List<Profile> getProfilePagination(int start, int size) {
		String hql = "From Profile";
		HibernateUtil.openSession();
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(size);
		query.setFetchSize(size - start);
		/*
		 * 
		 * setMaxResults limits the number of results the query will ever get.
		 * setFetchSize tells the jdbc driver how many rows to return in one
		 * chunk, for large queries. Say you want 1000 rows. If you set the
		 * fetch size to 100, the db will return 100, then another 100 when you
		 * want more, and so on. setFetchSize will do nothing if your driver
		 * does not support it.
		 */
		List<Profile> obj_list = query.list();
		return obj_list;

	}

}
