package com.iemr.inventory.repository.patientreturn;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.stockExit.ItemReturnEntry;
@Repository
@RestResource(exported = false)
public interface ItemReturnEntryRepo extends CrudRepository<ItemReturnEntry, Integer>{ 

}
