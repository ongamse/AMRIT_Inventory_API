package com.iemr.inventory.repo.uom;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.uom.M_Uom;

@Repository
@RestResource(exported = false)
public interface UomRepo extends CrudRepository<M_Uom, Integer> {

	
	@Query("SELECT u FROM M_Uom u WHERE u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Uom> getUom(@Param("providerServiceMapID")Integer providerServiceMapID);
    
	
	@Query("SELECT u FROM M_Uom u WHERE u.uomID=:uOMID")
	M_Uom geteditedData(@Param("uOMID")Integer uOMID);

}
