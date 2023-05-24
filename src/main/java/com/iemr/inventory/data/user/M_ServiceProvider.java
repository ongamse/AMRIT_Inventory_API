package com.iemr.inventory.data.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.iemr.inventory.utils.mapper.OutputMapper;


@Entity
@Table(name="m_ServiceProvider")
public class M_ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int ServiceProviderId; 
	 private String ServiceProviderName;
	 private Date JoiningDate;
	 private int StateId;
	 private String LogoFileName;
	 private String LogoFilePath;
	 private String PrimaryContactName;
	 private String PrimaryContactNo;
	 private String PrimaryContactEmailID;
	 private String PrimaryContactAddress;
	 private String PrimaryContactValidityTillDate;
	 private String SecondaryContactName;
	 private String SecondaryContactNo;
	 private String SecondaryContactEmailID;
	 private String SecondaryContactAddress;
	 private Date SecondaryContactValidityTillDate;
	 private int Deleted;
	 private String CreatedBy;
	 private java.util.Date CreatedDate;
	 private String ModifiedBy;
	 private java.util.Date LastModDate;
	 
	 
	 
	 @Transient
		private OutputMapper outputMapper = new OutputMapper();

		@Override
		public String toString() {
			return outputMapper.gson().toJson(this);
		}

}
