package com.iemr.inventory.data.stockentry;

import java.util.Date;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemBatchList {

	
	@Expose
	private Long itemStockEntryID;

	@Expose
	private Integer facilityID;

	@Expose
	private Integer itemID;

	@Expose
	private Integer quantity;

	@Expose
	private Integer quantityInHand;

	@Expose
	private String batchNo;

	@Expose
	private Date expiryDate;
	
	@Expose
	private Long expiresIn;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
