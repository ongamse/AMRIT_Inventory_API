package com.iemr.inventory.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.items.M_ItemForm;

@Repository
@RestResource(exported = false)
public interface ItemFormRepo extends CrudRepository<M_ItemForm, Integer> {
	
	@Query("select u from M_ItemForm u")
	List<M_ItemForm> getAll();
	
	List<M_ItemForm> findByDeleted(Boolean deleted);
	
	List<M_ItemForm> findByProviderServiceMapID(Integer providerServiceMapID);


}
