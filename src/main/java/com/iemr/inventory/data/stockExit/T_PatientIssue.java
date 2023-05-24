package com.iemr.inventory.data.stockExit;

import java.util.Date;
import java.util.List;

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
@Table(name = "t_patientissue")
@Data
public class T_PatientIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "PatientIssueID")
	private Long patientIssueID;
	
	@Expose
	@Column(name="VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long benRegID;

	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name="SyncFacilityID")
	private Integer syncFacilityID;

	@Expose
	@Column(name = "BenVisitID")
	private Integer visitID;

	@Expose
	@Column(name = "PatientName")
	private String patientName;

	@Expose
	@Column(name = "Age")
	private Integer age;

	@Expose
	@Column(name = "Gender")
	private String gender;

	@Expose
	@Column(name = "DoctorName")
	private String doctorName;

	@Expose
	@Column(name = "PrescriptionID")
	private Integer prescriptionID;

	@Expose
	@Column(name = "Reference")
	private String reference;

	@Expose
	@Column(name = "IssueType")
	private String issueType;

	@Expose
	@Column(name = "IssuedBy")
	private String issuedBy;

	@Transient
	@Expose
	private List<ItemStockExit> itemStockExit;

	@Transient
	@Expose
	private List<ItemStockExitMap> itemStockExitMap;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

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
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;

	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Long parkingPlaceID;

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
