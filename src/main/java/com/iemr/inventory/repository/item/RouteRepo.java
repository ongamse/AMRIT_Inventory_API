package com.iemr.inventory.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.items.M_Route;

@Repository
@RestResource(exported = false)
public interface RouteRepo extends CrudRepository<M_Route, Integer> {
	
	@Query("select u from M_Route u")
	List<M_Route> getAll();
	
	List<M_Route> findByDeleted(Boolean deleted);
	
	List<M_Route> findByProviderServiceMapID(Integer providerServiceMapID);


}
