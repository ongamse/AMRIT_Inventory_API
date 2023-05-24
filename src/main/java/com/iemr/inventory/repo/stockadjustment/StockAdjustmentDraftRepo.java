package com.iemr.inventory.repo.stockadjustment;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockadjustment.StockAdjustmentDraft;

@Repository
@RestResource(exported = false)
public interface StockAdjustmentDraftRepo extends CrudRepository<StockAdjustmentDraft, Long> {

	List<StockAdjustmentDraft> findByIsCompletedAndFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Boolean com,Integer facilityID,
			Timestamp fromDate, Timestamp toDate);

	@Query("SELECT sad "
			  + " FROM StockAdjustmentDraft sad "
			  + " inner JOIN sad.stockAdjustmentItemDraft sadi  "
			  + " inner JOIN sadi.itemStockEntry ise  "
			  + " WHERE sad.stockAdjustmentDraftID = :id and sadi.deleted=false")
	StockAdjustmentDraft getforedit(@Param("id")Long stockAdjustmentDraftID);

	@Transactional
	@Modifying
	@Query("UPDATE StockAdjustmentDraft c SET c.draftDesc = :draftDesc, c.modifiedBy = :modifiedBy,c.refNo=:refNo,c.draftName=:draftName WHERE c.stockAdjustmentDraftID = :id")
	Integer updateStock(@Param("id") Long id, @Param("draftDesc") String draftDesc,@Param("draftName") String draftName,
			@Param("refNo") String refNo,@Param("modifiedBy") String modifiedBy);

	@Transactional
	@Modifying
	@Query("UPDATE StockAdjustmentDraft c SET c.isCompleted = :isCompleted WHERE c.stockAdjustmentDraftID = :id")
	Integer updatecompleted(@Param("id")Long stockAdjustmentDraftID,@Param("isCompleted") boolean b);

}
