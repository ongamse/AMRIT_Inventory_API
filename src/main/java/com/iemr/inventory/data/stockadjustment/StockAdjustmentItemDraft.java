package com.iemr.inventory.data.stockadjustment;

import java.util.Date;

import javax.persistence.CascadeType;
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
import com.iemr.inventory.data.stockentry.ItemStockEntry;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_SADraftItemMapping")
@Data
public class StockAdjustmentItemDraft {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "SADraftItemMapID")
	private Long sADraftItemMapID;

//	@Expose
//	@Column(name = "StockAdjustmentDraftID")
//	private Integer stockAdjustmentDraftID;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "ItemStockEntryID", insertable = false, updatable = false)
	@JoinColumn(name = "ItemStockEntryID", insertable = false, updatable = false)
	@Expose
	private ItemStockEntry itemStockEntry;

	@Expose
	@Column(name = "ItemStockEntryID")
	private Long itemStockEntryID;

	@Expose
	@Column(name = "IsAdded")
	private Boolean isAdded;

	@Expose
	@Column(name = "AdjustedQuantity")
	private Integer adjustedQuantity;

	@Expose
	@Column(name = "Reason")
	private String reason;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "Status")
	private String status;
	
	@Expose
	@Column(name = "StockAdjustmentDraftID")
	private Long stockAdjustmentDraftID;

//	@JoinColumn(name = "stockAdjustmentDraftID", insertable = false, updatable = false)
//	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "StockAdjustmentDraftID",insertable = false, updatable = false)
//	private StockAdjustmentDraft stockAdjustmentDraft;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private Character processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
