package com.iemr.inventory.data.report;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "db_reporting.fact_patientissueexit", schema = "db_reporting")
public class PatientIssueExitReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="Fact_PatientIssueExitID")
	private Long factPatientIssueExitID;
	
	@Expose
	@Column(name="ItemStockExitID")
	private Long itemStockExitID;
	
	@Expose
	@Column(name="ItemStockEntryID")
	private Long itemStockEntryID;
	
	@Expose
	@Column(name="ItemID")
	private Integer itemID;
	
	@Expose
	@Column(name="ItemName")
	private String itemName;
	
	@Expose
	@Column(name="ItemCategoryName")
	private String itemCategoryName;
	
	@Expose
	@Column(name="BatchNo")
	private String batchNo;
	
	@Expose
	@Column(name="Strength")
	private String strength;
	
	@Expose
	@Column(name="QuantityGiven")
	private Integer quantityGiven;
	
	@Expose
	@Column(name="ExpiryDate")
	private Date expiryDate;
	
	@Expose
	@Column(name="FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name="PatientName")
	private String patientName;
	
	@Expose
	@Column(name="Age")
	private Integer age;
	
	@Expose
	@Column(name="Gender")
	private String gender;
	
	@Expose
	@Column(name="CreatedDate")
	private Timestamp createdDate;
	
	@Transient
	private Timestamp startDate;
	
	@Transient
	private Timestamp endDate;
}
