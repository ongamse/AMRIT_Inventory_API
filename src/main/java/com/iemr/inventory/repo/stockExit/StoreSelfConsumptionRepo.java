package com.iemr.inventory.repo.stockExit;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.inventory.data.stockExit.StoreSelfConsumption;

@Repository
@RestResource(exported = false)
public interface  StoreSelfConsumptionRepo extends  CrudRepository<StoreSelfConsumption,Long>{

	List<StoreSelfConsumption> findByFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Integer facilityID,Timestamp fromDate,Timestamp toDate);
	
	@Transactional
	@Modifying
	@Query("update StoreSelfConsumption p set p.vanSerialNo=p.consumptionID where p.vanSerialNo is null and p.consumptionID>0")
	Integer updateVanSerialNo();
}