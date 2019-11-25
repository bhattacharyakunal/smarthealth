package com.javasmartwork.io.hc.claims.model;

public enum ClaimParamCategory {
	
	SEARCH_PARAM_CODE(""),
	INCLUDES("_include"),
	SORT_RESULT(""),
	OTHER_OPTIONS(""),
	REVERSE("");
	
	private String paramInput;
	
	ClaimParamCategory(String paramInput){
		this.paramInput = paramInput; 
	}
	public String getParamInput() {
		return paramInput;
	}
	public void setParamInput(String paramInput) {
		this.paramInput = paramInput;
	}
}
