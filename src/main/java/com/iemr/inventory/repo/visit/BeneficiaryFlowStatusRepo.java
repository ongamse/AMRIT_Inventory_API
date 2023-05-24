package com.iemr.inventory.repo.visit;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.visit.BeneficiaryFlowStatus;

@Repository
@RestResource(exported = false)
public interface BeneficiaryFlowStatusRepo extends CrudRepository<BeneficiaryFlowStatus, Long> {

	List<BeneficiaryFlowStatus> findByBeneficiaryRegIDAndProviderServiceMapIdAndDoctorFlagInAndBenVisitIDNotNull(Long benRegID,Integer providerservicemapID,Short[] arra);
	
//	List<BeneficiaryFlowStatus> findByBenName(Long benRegID,Short[] arra);
}
