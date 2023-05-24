package com.iemr.inventory.repo.pharmacologicalcategory;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.pharmacologicalcategory.M_Pharmacologicalcategory;

@Repository
@RestResource(exported = false)
public interface PharmacologicalcategoryRepo extends CrudRepository<M_Pharmacologicalcategory, Integer>{
   
	
	
	@Query("SELECT u FROM M_Pharmacologicalcategory u WHERE u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Pharmacologicalcategory> getPhormacologicalData(@Param("providerServiceMapID")Integer providerServiceMapID);
   
	
	@Query("SELECT u FROM M_Pharmacologicalcategory u WHERE u.pharmacologyCategoryID=:pharmCategoryID")
	M_Pharmacologicalcategory editPhamacologicalData(@Param("pharmCategoryID")Integer pharmCategoryID);

}
