package com.iemr.inventory.model.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class DailyStockSummary {

	private Long slNo;

	private Timestamp date;

	private String facilityName;

	private String itemName;

	private String itemCategory;

	private Long quantityReceived;

	private Long openingStock;

	private Long quantityDispensed;
	
	private Long adjustmentReceipt;

	private Long adjustmentIssue;

	private Long closingStock;

	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
}
