package com.iemr.inventory.repository.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.store.M_Van;

@Repository
@RestResource(exported = false)
public interface VanMasterRepository extends CrudRepository<M_Van, Integer> {

	M_Van findOneByFacilityIDAndDeleted(Integer storeID, boolean b);

}