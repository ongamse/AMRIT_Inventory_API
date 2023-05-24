package com.iemr.inventory.data.patientreturn;

import java.sql.Timestamp;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemDetailModel {
	
	@Expose
	private Integer itemID;
	
	@Expose
	private String itemName;
	
	@Expose
	private String batchNo;
	
	@Expose
	private Integer issuedQuantity;
	
	@Expose
	private Timestamp dateofIssue;
	
	@Expose
	private Integer returnQuantity;
	
	@Expose
	private Boolean discontinued;
	
	@Expose
	private Boolean itemDeleted;
	
	@Expose
	private Long itemStockExitID;
	
	@Expose
	private Long itemStockEntryID;
	
	@Expose
	private Long visitID;
	
	@Expose
	private Long visitCode;
	
	@Expose
	private Long benRegID;
	
	@Expose
	private Integer providerServiceMapID;

	@Expose
	private Integer facilityID;
	
	@Expose
	private String createdBy;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public ItemDetailModel(Integer itemID, String itemName, String batchNo, Integer issuedQuantity, Timestamp dateofIssue,Boolean discontinued,
			Boolean itemDeleted, Long itemStockExitID, Long itemStockEntryID, Long visitID, Long visitCode, Long benRegID,
			Integer providerServiceMapID, Integer facilityID) {

		this.itemID=itemID;
		this.itemName=itemName;
		this.batchNo=batchNo;
		this.issuedQuantity=issuedQuantity;
		this.dateofIssue=dateofIssue;
		this.discontinued=discontinued;
		this.itemDeleted=itemDeleted;
		this.itemStockExitID=itemStockExitID;
		this.itemStockEntryID=itemStockEntryID;
		this.visitID=visitID;
		this.visitCode=visitCode;
		this.benRegID=benRegID;
		this.providerServiceMapID=providerServiceMapID;
		this.facilityID=facilityID;
		
	}
}
