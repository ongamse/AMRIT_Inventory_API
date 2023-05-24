package com.iemr.inventory.repository.itemfacilitymapping;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.itemfacilitymapping.V_fetchItemFacilityMap;

@Repository
@RestResource(exported = false)
public interface V_fetchItemFacilityMapRepo extends CrudRepository<V_fetchItemFacilityMap, Integer> {
    
	@Query("SELECT u FROM V_fetchItemFacilityMap u where u.providerServiceMapID = :providerServiceMapID")
	ArrayList<V_fetchItemFacilityMap> getAllFacilityMappedData(@Param("providerServiceMapID") Integer providerServiceMapID);

}
