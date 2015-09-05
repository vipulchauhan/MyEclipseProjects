package org.resources.filters;

import javax.ws.rs.QueryParam;

public class ProfileFilterBean {
	@QueryParam("year")
	private Integer year;
	@QueryParam("start")
	private Integer start;
	@QueryParam("size")
	private Integer size;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
