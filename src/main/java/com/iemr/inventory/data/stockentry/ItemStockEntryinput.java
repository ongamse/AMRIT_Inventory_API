package com.iemr.inventory.data.stockentry;

import java.sql.Timestamp;

import javax.persistence.Transient;

import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemStockEntryinput {

	private Long stockAdjustmentDraftID;
	
	private Long stockAdjustmentID;
	
	private Long consumptionID;
	
	private Long patientIssueID;
	
	private Long stockTransferID;
	
	private Long phyEntryID;
	
	private Integer facilityID;
	
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp fromDate;
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp toDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
	

