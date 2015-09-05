package org.dto;



public class Links {

	private String url;
	private String rel;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public Links(String url, String rel) {
		super();
		this.url = url;
		this.rel = rel;
	}

	public Links() {
		super();
	}

	
}
