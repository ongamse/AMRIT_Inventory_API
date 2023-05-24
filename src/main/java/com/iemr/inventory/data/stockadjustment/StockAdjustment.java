package com.iemr.inventory.data.stockadjustment;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_StockAdjustment")
@Data
public class StockAdjustment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "StockAdjustmentID")
	private Long stockAdjustmentID;

	@Expose
	@Transient
	private Long stockAdjustmentDraftID;

	@Expose
	@Column(name="VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;

	@Expose
	@Column(name = "SyncFacilityID")
	private Integer syncFacilityID;

	@Expose
	@Column(name = "RefNo")
	private String refNo;

	@Expose
	@Column(name = "Status")
	private String status;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "VanID")
	private Long vanID;

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
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	// @OneToMany(mappedBy = "stockAdjustmentDraft")
	// @OneToMany(fetch =
	// FetchType.EAGER,mappedBy="stockAdjustmentDraft",cascade =
	// CascadeType.ALL)
	@Expose
	@Transient
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	 @JoinColumn(name = "stockAdjustmentID",referencedColumnName = "vanSerialNo", insertable = false, updatable =	 false)
	private List<StockAdjustmentItem> stockAdjustmentItem;

	@Expose
	@Transient
	private List<StockAdjustmentItemDraftEdit> stockAdjustmentItemDraftEdit;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	
	
}
