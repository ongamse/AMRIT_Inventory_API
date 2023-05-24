package com.iemr.inventory.repo.supplier;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.supplier.M_Supplier;

@Repository
@RestResource(exported = false)
public interface SupplierRepo extends CrudRepository<M_Supplier, Integer> {
  
	@Query("SELECT u FROM M_Supplier u WHERE u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Supplier> getSupplierData(@Param("providerServiceMapID")Integer providerServiceMapID);
    
	
	@Query("SELECT u FROM M_Supplier u WHERE u.supplierID=:supplierID")
	  M_Supplier geteditedData(@Param("supplierID")Integer supplierID);
	
	

}
