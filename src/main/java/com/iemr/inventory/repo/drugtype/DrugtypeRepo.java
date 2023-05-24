package com.iemr.inventory.repo.drugtype;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.drugtype.M_Drugtype;

@Repository
@RestResource(exported = false)
public interface DrugtypeRepo extends CrudRepository<M_Drugtype, Integer>{
     
	
	@Query("SELECT u FROM M_Drugtype u WHERE u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Drugtype> getDrugtypeData(@Param("providerServiceMapID")Integer providerServiceMapID);
   
	
	@Query("SELECT u FROM M_Drugtype u WHERE u.drugTypeID=:drugTypeID")
	  M_Drugtype geteditedData(@Param("drugTypeID")Integer drugTypeID);

}
