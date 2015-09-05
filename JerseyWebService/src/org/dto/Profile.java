package org.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileID;
	private String profileUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public String getProfileUser() {
		return profileUser;
	}

	public void setProfileUser(String profileUser) {
		this.profileUser = profileUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Profile [profileID=" + profileID + ", profileUser="
				+ profileUser + ", createDate=" + createDate + "]";
	}

}
