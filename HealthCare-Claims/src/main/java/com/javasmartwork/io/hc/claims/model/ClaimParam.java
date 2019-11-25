package com.javasmartwork.io.hc.claims.model;

public enum ClaimParam {
	
	LANGUAGE_MATCHES("_language",Boolean.TRUE,Boolean.FALSE),
	LANGUAGE_EXACTLY("_language",Boolean.FALSE,Boolean.TRUE);
	
	private String paramInput;
	private Boolean matches;
	private Boolean exactly;
	
	ClaimParam(String paramInput,Boolean matches,Boolean exactly){
		this.paramInput = paramInput;
		this.matches = matches;
		this.exactly = exactly;
	}
	public String getParamInput() {
		return paramInput;
	}
	public void setParamInput(String paramInput) {
		this.paramInput = paramInput;
	}
	public Boolean getMatches() {
		return matches;
	}
	public void setMatches(Boolean matches) {
		this.matches = matches;
	}
	public Boolean getExactly() {
		return exactly;
	}
	public void setExactly(Boolean exactly) {
		this.exactly = exactly;
	}
	
}
