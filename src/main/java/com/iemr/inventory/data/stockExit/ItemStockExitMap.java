package com.iemr.inventory.data.stockExit;

import java.util.Date;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemStockExitMap {
	
	@Expose
	private String itemName;
	
	@Expose
	private String batchNo;
	
	@Expose
	private String createdDate;
	
	@Expose
	private String createdBy;
	
	@Expose
	private Integer quantity;
	
	@Expose
	private Boolean deleted;

	@Expose
	private Date expiryDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}


}
