package com.iemr.inventory.model.report;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class InwardStockReport {
	
	private Long slNo;

	private String facilityName;
	
	private String itemName;
	
	private String itemCategory;
	
	private String batchNo;
	
	private Double unitCostPrice;
	
	private Date expiryDate;
	
	private Timestamp inwardDate;
	
	private Integer quantity;
	
	private String entryType;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
}
