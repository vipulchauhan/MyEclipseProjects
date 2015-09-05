package org.service;

import java.util.List;

import org.dao.ProfileDao;
import org.dao.ProfileDaoImpl;
import org.dto.Profile;

public class ProfileServiceImpl implements ProfileService {

	private ProfileDao ProfileDao;

	public ProfileServiceImpl() {
		super();
		ProfileDao = new ProfileDaoImpl();
	}

	@Override
	public Profile getProfile(String profileUser) {

		return ProfileDao.getProfile(profileUser);
	}

	@Override
	public int addProfile(Profile profile) {

		return ProfileDao.addProfile(profile);
	}

	@Override
	public int updateProfile(Profile profile) {

		return ProfileDao.updateProfile(profile);
	}

	@Override
	public int deleteProfile(int profileId) {

		return ProfileDao.deleteProfile(profileId);
	}

	@Override
	public List<Profile> getProfiles() {

		return ProfileDao.getProfiles();
	}

	@Override
	public List<Profile> getProfileByYear(int year) {

		return ProfileDao.getProfileByYear(year);
	}

	@Override
	public List<Profile> getProfilePagination(int start, int size) {

		return ProfileDao.getProfilePagination(start, size);
	}

}
