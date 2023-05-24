package com.iemr.inventory.model.report;

import java.sql.Date;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class YearlyReport {

	private Long slNo;

	private Integer year;

	private String facilityName;

	private String itemName;

	private String itemCategory;

	private String batchNo;

	private Double unitCostPrice;

	private Date expiryDate;

	private Long quantityReceived;

	private Long openingStock;

	private Long dispensedQuantity;

	private Long adjustmentReceipt;

	private Long adjustmentIssue;

	private Long closingStock;

	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
}
