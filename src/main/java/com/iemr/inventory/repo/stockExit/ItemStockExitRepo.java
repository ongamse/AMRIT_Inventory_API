package com.iemr.inventory.repo.stockExit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockExit.ItemStockExit;

@Repository
@RestResource(exported = false)
public interface ItemStockExitRepo extends CrudRepository<ItemStockExit,Long> {

	
	List<ItemStockExit> findByExitTypeIDAndSyncFacilityIDAndExitType(Long id,Integer integer, String type );
	
	@Transactional
	@Modifying
	@Query("update ItemStockExit p set p.vanSerialNo=p.itemStockExitID where p.vanSerialNo is null and p.itemStockExitID>0")
	Integer updateVanSerialNo();
}
