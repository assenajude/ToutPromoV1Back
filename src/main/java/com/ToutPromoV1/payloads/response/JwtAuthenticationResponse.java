package com.ToutPromoV1.payloads.response;

public class JwtAuthenticationResponse {
	
	private String accessToken;
	private String tokenType = "Bearer";
	
	
	public JwtAuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	

}
