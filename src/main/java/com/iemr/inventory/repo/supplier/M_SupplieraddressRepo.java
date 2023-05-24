package com.iemr.inventory.repo.supplier;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.supplier.M_Supplieraddress;

@Repository
@RestResource(exported = false)
public interface M_SupplieraddressRepo extends CrudRepository<M_Supplieraddress,Integer>{
	

}
