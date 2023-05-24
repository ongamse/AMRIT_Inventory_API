package com.iemr.inventory.repo.stockExit;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.inventory.data.stockExit.T_StockTransfer;

@Repository
@RestResource(exported = false)
public interface StockTransferRepo  extends  CrudRepository<T_StockTransfer,Long>{
	
	
	List<T_StockTransfer> findByCreatedDateBetweenAndTransferFromFacilityIDOrCreatedDateBetweenAndTransferToFacilityIDOrderByCreatedDateDesc(Timestamp fromDate,Timestamp toDate,Integer fromfacilityID,Timestamp fromDate1,Timestamp toDate1,Integer tofacilityID);

	@Query(nativeQuery=true,value="select van.vanID from m_facility fac left join m_van  van on fac.facilityID=van.facilityID"
			+ " where fac.IsMainFacility is false and van.deleted is false and fac.FacilityID = :facID")
	Long findVanIDByFacID(@Param("facID")Integer transferToFacilityID);

	@Transactional
	@Modifying
	@Query("update T_StockTransfer p set p.vanSerialNo=p.stockTransferID where p.vanSerialNo is null and p.stockTransferID>0")
	Integer updateVanSerialNo();
}
