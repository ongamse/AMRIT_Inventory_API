package com.iemr.inventory.service.store;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.data.store.M_Van;
import com.iemr.inventory.repository.store.MainStoreRepo;
import com.iemr.inventory.repository.store.VanMasterRepository;
import com.iemr.inventory.utils.exception.IEMRException;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private MainStoreRepo mainStoreRepo;
	
	@Autowired
	private VanMasterRepository vanMasterRepository;
	
//	@Autowired
//	private SubStoreRepo subStoreRepo;
	
	@Override
	public M_Facility createMainStore(M_Facility mainStoreFacility) {

		// TODO Auto-generated method stub
		return mainStoreRepo.save(mainStoreFacility);
	}

//	@Override
//	public SubStoreFacility createSubStore(SubStoreFacility subStoreFacility) {
//		// TODO Auto-generated method stub
//		return subStoreRepo.save(subStoreFacility);
//	}

	@Override
	public M_Facility getMainStore(Integer mainStoreID) {
		// TODO Auto-generated method stub
		return mainStoreRepo.findOne(mainStoreID);
	}

//	@Override
//	public SubStoreFacility getSubStore(Integer subStoreID) {
//		// TODO Auto-generated method stub
//		return subStoreRepo.findOne(subStoreID);
//	}

	@Override
	public List<M_Facility> getAllMainStore(Integer providerServiceMapID) {
		// TODO Auto-generated method stub
		return (List<M_Facility>) mainStoreRepo.findByProviderServiceMapID(providerServiceMapID);
	}

//	@Override
//	public List<SubStoreFacility>  getAllSubStore(Integer providerServiceMapID) {
//		// TODO Auto-generated method stub
//		return (List<SubStoreFacility>) subStoreRepo.findByProviderServiceMapID(providerServiceMapID);
//	}

	@Override

	public List<M_Facility> addAllMainStore(List<M_Facility> maniStore) {
		// TODO Auto-generated method stub
		return (List<M_Facility>) mainStoreRepo.save(maniStore);
	}

	@Override
	public ArrayList<M_Facility> getMainFacility(Integer providerServiceMapID, Boolean isMainFacility) {
		ArrayList<M_Facility> data=mainStoreRepo.getAllMainFacility(providerServiceMapID,isMainFacility);
		return data;
	}

	@Override
	public ArrayList<M_Facility> getMainFacility(Integer providerServiceMapID, Boolean isMainFacility,
			Integer mainFacilityID) {
		ArrayList<M_Facility> data=mainStoreRepo.getAllMainFacility(providerServiceMapID,isMainFacility,mainFacilityID);
		return data;
	}

	@Override
	public ArrayList<M_Facility> getChildFacility(Integer providerServiceMapID, Integer mainFacilityID) {
		// TODO Auto-generated method stub
		ArrayList<M_Facility> data=mainStoreRepo.getChildFacility(providerServiceMapID,mainFacilityID);
		return data;
	}

	@Override
	public M_Facility deleteStore(M_Facility facility) throws IEMRException {
		// TODO Auto-generated method stub
		
		M_Facility stores=mainStoreRepo.findOne(facility.getFacilityID());
		if(stores!=null && facility.getDeleted()!=null){
			if(facility.getDeleted()){
				List<M_Facility> childStore=mainStoreRepo.findByMainFacilityIDAndDeleted(facility.getFacilityID(),false);
				if(childStore.size()==0 ){
					stores.setDeleted(true);
					stores=mainStoreRepo.save(stores);
				}else{
					throw new IEMRException("Child Stores are still active");
				}
			}else{
				if(stores.getMainFacilityID()!=null){
					M_Facility parentStore=mainStoreRepo.findByFacilityIDAndDeleted(stores.getMainFacilityID(),false);
					if(parentStore!=null){
						stores.setDeleted(false);
						stores=mainStoreRepo.save(stores);
					}else{
						throw new IEMRException("Parent Stores are still inactive");
					}
				}else{
					stores.setDeleted(false);
					stores=mainStoreRepo.save(stores);
				}
				
				
			}
		}else{
			throw new IEMRException("No store available");
		}
		return stores;
	}

	@Override
	public List<M_Facility> getAllActiveStore(M_Facility facility) {
		// TODO Auto-generated method stub
		return mainStoreRepo.findByProviderServiceMapIDAndDeleted(facility.getProviderServiceMapID(),facility.getDeleted());
	}

	@Override
	public M_Facility getStoreByID(Integer facility) {
		// TODO Auto-generated method stub
		return mainStoreRepo.findByFacilityIDAndDeleted(facility,false);
	}

	@Override
	public M_Van getVanByStoreID(Integer storeID) {
		// TODO Auto-generated method stub
		return vanMasterRepository.findOneByFacilityIDAndDeleted(storeID,false);
	}

//	@Override
//	public List<SubStoreFacility> addAllSubStore(List<SubStoreFacility> subStore) {
//		// TODO Auto-generated method stub
//		return (List<SubStoreFacility>) subStoreRepo.save(subStore);
//	}

}
