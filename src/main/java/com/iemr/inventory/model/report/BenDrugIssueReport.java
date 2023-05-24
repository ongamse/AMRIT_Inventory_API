package com.iemr.inventory.model.report;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class BenDrugIssueReport {

	private Long slNo;

	private Timestamp date;
	
	private String beneficiaryName;
	
	private String gender;
	
	private Integer age;
	
	private String itemName;
	
	private String itemCategory;
	
	private String batchNo;
	
	private Date expiryDate;
	
	private String strength;
	
	private Integer dispensedQuantity;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
}
