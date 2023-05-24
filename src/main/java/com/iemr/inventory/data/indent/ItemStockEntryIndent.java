package com.iemr.inventory.data.indent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.stockentry.PhysicalStockEntry;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="t_itemstockentry")
@Data
public class ItemStockEntryIndent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="ItemStockEntryID")
	private Integer itemStockEntryID;
	
	@Expose
	@Column(name="FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name="ItemID")
	private Integer itemID;
	
	@Expose
	@Column(name="Quantity")
	private Integer quantity;
	
	@Expose
	@Column(name="QuantityInHand")
	private Integer quantityInHand;
	
	@Expose
	@Column(name="UnitCostPrice")
	private Double totalCostPrice;
	
	@Expose
	@Column(name="BatchNo")
	private String batchNo;
	
	@Expose
	@Column(name="ExpiryDate")
	private Date expiryDate;
	
	@Expose
	@Column(name="EntryTypeID")
	private Integer entryTypeID;
	
	@Expose
	@Column(name="VanID")
	private Long vanID;	

	
	@Expose
	@Column(name="EntryType")
	private String entryType;
	
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed", insertable = false, updatable = true)
	private Character processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Transient
	private Long totalQuantity ;

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
