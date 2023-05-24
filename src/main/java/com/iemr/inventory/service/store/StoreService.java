package com.iemr.inventory.service.store;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.data.store.M_Van;
import com.iemr.inventory.utils.exception.IEMRException;

public interface StoreService {

	M_Facility createMainStore(M_Facility mainStoreFacility);

	M_Facility getMainStore(Integer mainStoreID);

	List<M_Facility> getAllMainStore(Integer providerServiceMapID);

	List<M_Facility> addAllMainStore(List<M_Facility> maniStore);

	ArrayList<M_Facility> getMainFacility(Integer providerServiceMapID, Boolean isMainFacility);

	ArrayList<M_Facility> getMainFacility(Integer providerServiceMapID, Boolean isMainFacility, Integer mainFacilityID);
	
	ArrayList<M_Facility> getChildFacility(Integer providerServiceMapID, Integer mainFacilityID);
	
	M_Facility deleteStore(M_Facility facility) throws IEMRException;
	
	List<M_Facility> getAllActiveStore(M_Facility facility);
	
	M_Facility getStoreByID(Integer facility);

	M_Van getVanByStoreID(Integer storeID);
	

	
}
