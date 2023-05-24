package com.iemr.inventory.data.items;

import java.sql.Date;

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
@Table(name = "m_itemcategory")
@Data
public class M_ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="ItemCategoryID")
	private Integer itemCategoryID;
	
	@Expose
	@Column(name="AlertBeforeDays")
	private Integer alertBeforeDays;
	
	@Expose
	@Column(name="IssueType")
	private String issueType;
	
	@Expose
	@Column(name="ItemCategoryName")
	private String itemCategoryName;
	
	@Expose
	@Column(name="ItemCategoryDesc")
	private String itemCategoryDesc;
	
	@Expose
	@Column(name="ItemCategoryCode")
	private String itemCategoryCode;
	
	@Expose
	@Column(name="Status")
	private String status;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name="Deleted",insertable = false, updatable = false)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed",insertable = false, updatable = false)
	private Character processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate",insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate",insertable = false, updatable = false)
	private Date lastModDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
