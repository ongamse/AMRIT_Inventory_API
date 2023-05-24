package com.iemr.inventory.model.report;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ConsumptionReport {

    private Long slNo;

    private String facilityName;

    private String itemName;

    private String itemCategory;

    private String batchNo;

    private Double unitCostPrice;

    private Date expiryDate;

    private Timestamp consumptionDate;

    private Integer consumptionQuantity;

    private String consumptionType;
     
    private String beneficiaryID;

    private String beneficiaryName;
    public ConsumptionReport(String batchNo,Timestamp consumptionDate,Integer consumptionQuantity,String consumptionType,
            Date expiryDate,String facilityName,String itemCategory,String itemName,Double unitCostPrice,
            String beneficiaryName,String beneficiaryID)
    {
        this.batchNo=batchNo;
        this.consumptionDate=consumptionDate;
        this.consumptionQuantity=consumptionQuantity;
        this.consumptionType=consumptionType;
        this.expiryDate=expiryDate;
        this.facilityName=facilityName;
        this.itemCategory=itemCategory;
        this.itemName=itemName;
        this.unitCostPrice=unitCostPrice;
        this.beneficiaryName=beneficiaryName;
        this.beneficiaryID=beneficiaryID;
        
    }
    public ConsumptionReport()
    {
    	
    }
    @Override
    public String toString() {

        return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
                .setDateFormat("dd-MM-yyyy").create().toJson(this);

    }
}
