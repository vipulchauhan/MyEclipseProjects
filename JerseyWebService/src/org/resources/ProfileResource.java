package org.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.dto.Profile;
import org.resources.filters.ProfileFilterBean;
import org.service.ProfileService;
import org.service.ProfileServiceImpl;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService = new ProfileServiceImpl();
	private static Logger logger = Logger.getLogger(ProfileResource.class);

	@GET
	// public List<Profile> getProfiles(@QueryParam("year") Integer
	// year,@QueryParam("start") Integer start,@QueryParam("size") Integer size)
	// {
	public List<Profile> getProfiles(
			@BeanParam ProfileFilterBean profileFilterBean) {
		logger.info("\n------USER----------");
		logger.info("getProfiles request received for year "
				+ profileFilterBean.getYear());
		logger.info("\n------USER-END----------");
		List<Profile> profile_list = null;
		if (profileFilterBean.getYear() != null) {
			logger.info("calling getProfileByYear  for year "
					+ profileFilterBean.getYear());
			profile_list = profileService.getProfileByYear(profileFilterBean
					.getYear());

		} else if (profileFilterBean.getStart() != null
				&& profileFilterBean.getSize() != null) {
			logger.info("calling getProfilePagination  for start and size "
					+ profileFilterBean.getStart() + " , "
					+ profileFilterBean.getSize());
			profile_list = profileService.getProfilePagination(
					profileFilterBean.getStart(), profileFilterBean.getSize());

		} else {
			profile_list = profileService.getProfiles();
		}
		return profile_list;
	}

	@GET
	@Path("/{profileUser}")
	public Profile getProfile(@PathParam("profileUser") String userName) {
		logger.info("\n------USER----------");
		logger.info("getProfile request received");
		logger.info("\n------USER-END----------");

		return profileService.getProfile(userName);
	}

	@POST
	public Profile addProfile(Profile profile) {

		logger.info("\n------USER----------");
		logger.info("addProfile request received :- " + profile);

		Integer i = profileService.addProfile(profile);
		logger.info("addProfile request responce :- " + i);
		logger.info("\n------USER-END----------");
		return profile;
	}

	@PUT
	@Path("/{profileID}")
	public Profile updateProfile(@PathParam("profileID") int id, Profile profile) {

		logger.info("\n------USER----------");
		logger.info("updateProfile request received :- " + profile);
		profile.setProfileID(id);
		Integer i = profileService.updateProfile(profile);
		logger.info("updateProfile request responce :- " + i);
		logger.info("\n------USER-END----------");
		return profile;
	}

	@DELETE
	@Path("/{profileID}")
	public void deleteProfile(@PathParam("profileID") int id) {
		logger.info("\n------USER----------");
		logger.info("deleteProfile request received");
		logger.info("\n------USER-END----------");
		profileService.deleteProfile(id);

	}
}
