package com.iemr.inventory.service.visit;

import java.util.List;

import com.iemr.inventory.data.visit.BeneficiaryModel;
import com.iemr.inventory.utils.exception.IEMRException;

public interface VisitService {
	
	BeneficiaryModel getVisitDetail(String BenregID,Integer providerservicemapID,String auth) throws Exception;

	List<BeneficiaryModel> getVisitFromAdvanceSearch(String model, String auth) throws IEMRException;

}
