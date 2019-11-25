package com.javasmartwork.io.hc.claims.model;

public enum IncludesCategory {
	
	CARE_TEAM("Claim:care-team"),
	DETAIL_UDI("Claim:detail-udi"),
	CLAIM_ENCOUNTER("Claim:encounter"),
	CLAIM_ENTERER("Claim:enterer"),
	CLAIM_FACILITY("Claim:facility"),
	CLAIM_INSURER("Claim:insurer"),
	CLAIM_ITEM_UDI("Claim:item-udi"),
	CLAIM_PATIENT("Claim:patient"),
	CLAIM_PAYEE("Claim:payee"),
	CLAIM_PROCEDURE_UDI("Claim:procedure-udi"),
	CLAIM_PROVIDER("Claim:provider"),
	CLAIM_SUBDETAIL_UDI("Claim:subdetail-udi"),
	ALL("*");
	
	private String desc;
	private static final String INCLUDES_REQUEST_PARAM="_include";
	IncludesCategory(String desc){
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public static String getIncludesRequestParam() {
		return INCLUDES_REQUEST_PARAM;
	}
	
}
