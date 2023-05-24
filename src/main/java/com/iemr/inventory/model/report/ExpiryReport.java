package com.iemr.inventory.model.report;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class ExpiryReport {

	private Long slNo;

	private String facilityName;
	
	private String itemName;
	
	private String itemCategory;
	
	private String batchNo;
	
	private Double unitCostPrice;
	
	private Date expiryDate;
	
	private Integer quantityInHand;
	
//	private Integer qtyExpired;
//	
//  private Integer quantity;
	
	public ExpiryReport() {
		
	}
	public ExpiryReport(String facilityName,String itemName,String itemCategory,String batchNo, 
			Double unitCostPrice,Date expiryDate, Integer quantityInHand) 
	{
		
		this.facilityName= facilityName;
		this.itemName= itemName;
		this.itemCategory= itemCategory;
		this.batchNo= batchNo;
		this.unitCostPrice= unitCostPrice;
		this.expiryDate= expiryDate;
		this.quantityInHand= quantityInHand;
	}
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}

	}
