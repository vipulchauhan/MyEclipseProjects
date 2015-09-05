package org.service;

import java.util.List;

import org.dto.Profile;

public interface ProfileService {
	public Profile getProfile(String profileUser);

	public int addProfile(Profile profile);

	public int updateProfile(Profile profile);

	public int deleteProfile(int profileId);

	public List<Profile> getProfiles();

	List<Profile> getProfileByYear(int year);

	public List<Profile> getProfilePagination(int start, int size);

}
