package com.iemr.inventory.repo.stockEntry;


import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockentry.PhysicalStockEntry;

@Repository
@RestResource(exported = false)
public interface PhysicalStockEntryRepo  extends CrudRepository<PhysicalStockEntry, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE PhysicalStockEntry c SET c.deleted = :bool WHERE c.phyEntryID = :id")
	Integer updateDelete(@Param("id")Integer id,@Param("bool")Boolean bool);
	
	
	List<PhysicalStockEntry> findByFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Integer facilityID,Timestamp fromDate,Timestamp toDate);

	@Transactional
	@Modifying
	@Query("update PhysicalStockEntry p set p.vanSerialNo=p.phyEntryID where p.vanSerialNo is null and p.phyEntryID>0")
	Integer updatePhysicalStockEntryVanSerialNo();
}
