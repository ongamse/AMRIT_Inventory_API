package com.iemr.inventory.repo.stockadjustment;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraft;

@Repository
@RestResource(exported = false)
public interface StockAdjustmentItemDraftRepo extends CrudRepository<StockAdjustmentItemDraft, Long> {


	@Query(" SELECT sadi "
			  + " FROM StockAdjustmentItemDraft sadi  "
			  + " JOIN sadi.itemStockEntry ise "
			  + " WHERE sadi.sADraftItemMapID =:id")
	StockAdjustmentItemDraft getforedit(@Param("id")Long id);


	@Transactional
	@Modifying
	@Query("UPDATE StockAdjustmentItemDraft c SET c.deleted = true WHERE c.stockAdjustmentDraftID = :id")
	Integer updateDeleted(@Param("id")Long stockAdjustmentDraftID);

}
