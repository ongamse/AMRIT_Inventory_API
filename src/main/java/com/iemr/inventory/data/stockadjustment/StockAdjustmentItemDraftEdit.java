package com.iemr.inventory.data.stockadjustment;

import java.util.Date;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;


@Data
public class StockAdjustmentItemDraftEdit {


	@Expose
	private Long sADraftItemMapID;

	@Expose
	private Long sAItemMapID;
	
	@Expose
	private Long itemStockEntryID;
	@Expose
	private String itemName;
	@Expose
	private String batchID;
	@Expose
	private Integer quantityInHand;
	@Expose
	private Boolean isAdded;
	@Expose
	private Integer adjustedQuantity;
	@Expose
	private String reason;
	@Expose
	private Integer providerServiceMapID;
	@Expose
	private String status;
	@Expose
	private String createdBy;
	@Expose
	private Date createdDate;
	@Expose
	private String modifiedBy;
	@Expose
	private Date lastModDate;
	@Expose
	private Boolean deleted;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
