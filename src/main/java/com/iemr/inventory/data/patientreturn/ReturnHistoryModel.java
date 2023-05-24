package com.iemr.inventory.data.patientreturn;

import java.sql.Timestamp;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ReturnHistoryModel {
	
	@Expose
	private String itemName;
	
	@Expose
	private String batchNo;
	
	@Expose
	private Timestamp dateofIssue;
	
	@Expose
	private Integer issuedQuantity;
	
	@Expose
	private Timestamp returnDate;
	
	@Expose
	private Long visitID;
	
	@Expose
	private Long visitCode;
	
	@Expose
	private String patientName;
	
	@Expose
	private Integer age;
	
	@Expose
	private String gender;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	public ReturnHistoryModel(String itemName, String batchNo, Integer issuedQuantity,Timestamp dateofIssue, Long visitID,
			Long visitCode, String patientName, Integer age, String gender, Timestamp returnDate) {

		this.itemName=itemName;
		this.batchNo=batchNo;
		this.dateofIssue=dateofIssue;
		this.issuedQuantity=issuedQuantity;
		this.visitID=visitID;
		this.visitCode=visitCode;
		this.patientName=patientName;
		this.age=age;
		this.gender=gender;
		this.returnDate=returnDate;
		
		
	}
}
