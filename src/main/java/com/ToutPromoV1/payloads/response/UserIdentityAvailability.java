package com.ToutPromoV1.payloads.response;

public class UserIdentityAvailability {
	
	private boolean availbale;

	public boolean isAvailbale() {
		return availbale;
	}

	public void setAvailbale(boolean availbale) {
		this.availbale = availbale;
	}

	public UserIdentityAvailability(boolean availbale) {
		this.availbale = availbale;
	}
	
	

}
