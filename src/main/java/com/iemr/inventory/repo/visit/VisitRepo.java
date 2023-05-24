package com.iemr.inventory.repo.visit;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.visit.BenVisitDetail;

@Repository
@RestResource(exported = false)
public interface VisitRepo extends CrudRepository<BenVisitDetail, Long> {
	
	
	List<BenVisitDetail> findBybeneficiaryRegIDAndProviderServiceMapID(Long benRegID,Integer provider);

}
