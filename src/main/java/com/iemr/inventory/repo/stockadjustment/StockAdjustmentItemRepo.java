package com.iemr.inventory.repo.stockadjustment;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockadjustment.StockAdjustmentItem;
import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraft;

@Repository
@RestResource(exported = false)
public interface StockAdjustmentItemRepo extends CrudRepository<StockAdjustmentItem, Integer> {

//
//	@Query(" SELECT sadi "
//			  + " FROM StockAdjustmentItemDraft sadi  "
//			  + " JOIN sadi.itemStockEntry ise "
//			  + " WHERE sadi.sADraftItemMapID =:id")
//	StockAdjustmentItemDraft getforedit(@Param("id")Integer id);


	@Transactional
	@Modifying
	@Query("update StockAdjustmentItem p set p.vanSerialNo=p.sAItemMapID where p.vanSerialNo is null and p.sAItemMapID>0")
	Integer updateVanSerialNo();

	List<StockAdjustmentItem> findByStockAdjustmentIDAndSyncFacilityID(Long vanSerialNo, Integer syncFacilityID);

}
