package com.iemr.inventory.model.report;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class TransitReport {

	private Long slNo;
	
	private String fromFacilityName;
	
	private String tofacilityName;
	
	private String itemName;
	
	private String batchNo;
	
	private Double unitCostPrice;
	
	private Date expiryDate;
	
	private Timestamp OrderDate;
	
	private Timestamp IssueDate;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}

	public TransitReport(Long slNo, String itemName, String batchNo, Double unitCostPrice, Date expiryDate, String fromFacilityName,
			String tofacilityName, Timestamp OrderDate, Timestamp IssueDate) {
		
		this.itemName=itemName;
		this.batchNo=batchNo;
		this.unitCostPrice=unitCostPrice;
		this.expiryDate=expiryDate;
		this.fromFacilityName=fromFacilityName;
		this.tofacilityName=tofacilityName;
		this.OrderDate=OrderDate;
		this.IssueDate=IssueDate;
		this.slNo=slNo;

	}
}
