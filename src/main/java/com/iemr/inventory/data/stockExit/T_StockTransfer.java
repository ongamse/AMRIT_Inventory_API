package com.iemr.inventory.data.stockExit;

import java.util.Date;
import java.util.List;

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
import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="t_stocktransfer")
@Data
public class T_StockTransfer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="StockTransferID")
	private Long stockTransferID;
		
	
	@Expose
	@Column(name="VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name="TransferFromFacilityID")
	private Integer transferFromFacilityID;;
	
	@Expose
	@Column(name="SyncFacilityID")
	private Integer syncFacilityID;
	
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "transferFromFacilityID")
	private M_Facility transferFromFacility;
	
	@Expose
	@Column(name="TransferToFacilityID")
	private Integer transferToFacilityID;
	
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "transferToFacilityID")
	private M_Facility transferToFacility;
	
	@Expose
	@Column(name="RefNo")
	private String refNo;
	
	
	@Expose
	@Column(name="IssueType")
	private String issueType;
	
	@Transient
	@Expose
	private List<ItemStockExit>  itemStockExit;

	
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
	@Column(name = "VanID")
	private Long vanID;
	
	@Expose
	@Column(name = "ToVanID")
	private Long toVanID;
	
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

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
