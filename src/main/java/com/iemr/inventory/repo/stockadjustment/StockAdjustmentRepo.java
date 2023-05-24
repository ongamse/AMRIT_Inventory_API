package com.iemr.inventory.repo.stockadjustment;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockadjustment.StockAdjustment;

@Repository
@RestResource(exported = false)
public interface StockAdjustmentRepo extends CrudRepository<StockAdjustment, Long> {

	List<StockAdjustment> findByFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Integer facilityID,
			Timestamp fromDate, Timestamp toDate);

//	List<StockAdjustmentDraft> findByIsCompletedAndFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Boolean com,Integer facilityID,
//			Timestamp fromDate, Timestamp toDate);
//
//	@Query("SELECT sad "
//			  + " FROM StockAdjustmentDraft sad "
//			  + " inner JOIN sad.stockAdjustmentItemDraft sadi  "
//			  + " inner JOIN sadi.itemStockEntry ise  "
//			  + " WHERE sad.stockAdjustmentDraftID = :id")
//	StockAdjustmentDraft getforedit(@Param("id")Integer stockAdjustmentDraftID);
//
//	@Transactional
//	@Modifying
//	@Query("UPDATE StockAdjustmentDraft c SET c.draftDesc = :draftDesc, c.modifiedBy = :modifiedBy,c.refNo=:refNo,c.draftName=:draftName WHERE c.stockAdjustmentDraftID = :id")
//	Integer updateStock(@Param("id") Integer id, @Param("draftDesc") String draftDesc,@Param("draftName") String draftName,
//			@Param("refNo") String refNo,@Param("modifiedBy") String modifiedBy);

	@Transactional
	@Modifying
	@Query("update StockAdjustment p set p.vanSerialNo=p.stockAdjustmentID where p.vanSerialNo is null and p.stockAdjustmentID>0")
	Integer updateVanSerialNo();
}
