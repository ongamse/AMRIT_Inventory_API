package com.iemr.inventory.repo.manufacturer;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.manufacturer.M_Manufacturer;
import com.iemr.inventory.data.pharmacologicalcategory.M_Pharmacologicalcategory;

@Repository
@RestResource(exported = false)
public interface ManufacturerRepo extends CrudRepository<M_Manufacturer, Integer> {

	
	@Query("SELECT u FROM M_Manufacturer u WHERE u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Manufacturer> getManufacturerData(@Param("providerServiceMapID")Integer providerServiceMapID);
     
	
	@Query("SELECT u FROM M_Manufacturer u WHERE u.manufacturerID=:manufacturerID")
	   M_Manufacturer getEditData(@Param("manufacturerID")Integer manufacturerID);

}
