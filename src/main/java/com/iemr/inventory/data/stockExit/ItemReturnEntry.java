package com.iemr.inventory.data.stockExit;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_patientreturn")
@Data
public class ItemReturnEntry {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "PatientReturnID")
	private Long patientReturnID;

	@Expose
	@Column(name = "BenneficiaryRegID")
	private Long benRegID;
	
	@Expose
	@Column(name = "VisitID")
	private Long visitID;
	
	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;
	
	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name = "ItemExitID")
	private Long itemStockExitID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Timestamp lastModDate;
	
	@Transient
	private Timestamp fromDate;
	
	@Transient
	private Timestamp toDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
