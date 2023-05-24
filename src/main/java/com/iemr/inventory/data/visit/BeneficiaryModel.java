package com.iemr.inventory.data.visit;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class BeneficiaryModel {

	@Expose
	private Long beneficiaryRegID;
	
	@Expose
	private List<BenVisitDetail> benVisitDetail;
	
	@Expose
	private List<BeneficiaryFlowStatus> beneficiaryFlowStatus;
	
	@Expose
	private I_bendemographics i_bendemographics;
	
	
	@Expose
	private String beneficiaryID;
	
	@Expose
	private Short titleId;
	
	@Expose
	private String titleName;
	
	@Expose
	private String firstName;
	
	@Expose
	private String middleName;
	
	@Expose
	private String lastName;
	
	@Expose
	private Short statusID;
	
	@Expose
	private String statusName;
	
	@Expose
	private Integer genderID;
	
	@Expose
	private String genderName;
	
	@Expose
	private GenderModel m_gender;
	
	@Expose
	private Short maritalStatusID;
	
	@Expose
	private String maritalStatusName;
	
	@Expose
	private Short sexualOrientationId;
	
	@Expose
	private String sexualOrientationName;
	
	@Expose
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp dOB;
	
	@Expose
	private Integer age;
	
	@Expose
	private String fatherName;
	
	@Expose
	private String spouseName;
	
	@Expose
	private String govtIdentityNo;
	
	@Expose
	private Integer govtIdentityTypeID;
	
	@Expose
	private Short registeredServiceID;
	
	@Expose
	private String sourceOfInformation;
	
	@Expose
	private Boolean isHIVPos;
	
	@Expose
	private String placeOfWork;
	
	@Expose
	private String remarks;
	
	@Expose
	private Boolean changeInSelfDetails;
	
	@Expose
	private Boolean changeInAddress;
	
	@Expose
	private Boolean changeInContacts;
	
	@Expose
	private Boolean changeInIdentities;
	
	@Expose
	private Boolean changeInOtherDetails;
	
	@Expose
	private Boolean changeInFamilyDetails;
	
	@Expose
	private Boolean changeInAssociations;
	
	@Expose
	private Boolean is1097 = false;
	
	@Expose	
	private Boolean deleted;
	
	@Expose
	private String createdBy;
	
	@Expose
	private Timestamp createdDate;
	
	@Expose
	private String modifiedBy;
	
	@Expose
	private Timestamp lastModDate;
	
	public static Timestamp getTimestampData(Timestamp timestamp)
	{
		return timestamp;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
}
