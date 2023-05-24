package com.iemr.inventory.data.stockentry;

import java.util.Date;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemMasterWithQuantityMap {

	@Expose
	private Long itemStockEntryID;

	@Expose
	private Integer facilityID;

	@Expose
	private Integer itemID;

	@Expose
	private Integer quantityInHand;

	@Expose
	private Integer totalQuantity;
	
	@Expose
	private ItemMaster item;
	
	@Expose
	private Date expiryDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
