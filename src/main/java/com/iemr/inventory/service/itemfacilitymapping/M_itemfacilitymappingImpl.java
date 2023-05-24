package com.iemr.inventory.service.itemfacilitymapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.itemfacilitymapping.M_itemfacilitymapping;
import com.iemr.inventory.data.itemfacilitymapping.V_fetchItemFacilityMap;
import com.iemr.inventory.data.items.ItemInStore;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.stockentry.ItemStockEntry;
//import com.iemr.inventory.data.rolemaster.StateServiceMapping;
import com.iemr.inventory.repo.stockEntry.ItemStockEntryRepo;
import com.iemr.inventory.repository.item.ItemRepo;
import com.iemr.inventory.repository.itemfacilitymapping.M_itemfacilitymappingRepo;
import com.iemr.inventory.repository.itemfacilitymapping.V_fetchItemFacilityMapRepo;

@Service
public class M_itemfacilitymappingImpl implements M_itemfacilitymappingInter {

	@Autowired
	private V_fetchItemFacilityMapRepo v_fetchItemFacilityMapRepo;

	@Autowired
	private M_itemfacilitymappingRepo m_itemfacilitymappingRepo;

	@Autowired
	ItemStockEntryRepo itemStockEntryRepo;
	
	@Autowired
	ItemRepo itemRepo;

	@Override
	public ArrayList<M_itemfacilitymapping> mapItemtoStore(List<M_itemfacilitymapping> resList) {
		ArrayList<M_itemfacilitymapping> data = (ArrayList<M_itemfacilitymapping>) m_itemfacilitymappingRepo
				.save(resList);
		return data;
	}

	@Override
	public M_itemfacilitymapping editdata(Integer itemStoreMapID) {
		M_itemfacilitymapping data = m_itemfacilitymappingRepo.findOne(itemStoreMapID);
		return data;
	}

	@Override
	public M_itemfacilitymapping saveEditedItem(M_itemfacilitymapping getdataforedit) {
		M_itemfacilitymapping data = m_itemfacilitymappingRepo.save(getdataforedit);
		return data;
	}

	@Override
	public ArrayList<M_itemfacilitymapping> getsubitemforsubStote(Integer providerServiceMapID, Integer facilityID) {

		ArrayList<M_itemfacilitymapping> itemForsubStore = new ArrayList<M_itemfacilitymapping>();
		ArrayList<Object[]> resultSet = m_itemfacilitymappingRepo.getItemforSubstore(providerServiceMapID, facilityID);
		for (Object[] objects : resultSet) {
			if (objects != null && objects.length >= 3) {
				itemForsubStore.add(new M_itemfacilitymapping((Integer) objects[0], (String) objects[1],(Boolean) objects[2],(Integer) objects[3]));
			}

			// logger.debug("for getting state " + resultSet);
		}
		// logger.debug("getting response with stateid " +
		// stateServiceMappings);
		return itemForsubStore;
	}

	@Override
	public ArrayList<V_fetchItemFacilityMap> getAllFacilityMappedData(Integer providerServiceMapID) {
		ArrayList<V_fetchItemFacilityMap> data = v_fetchItemFacilityMapRepo
				.getAllFacilityMappedData(providerServiceMapID);
		return data;
	}

	@Override
	public List<ItemInStore> getItemMastersFromStoreID(Integer storeID) {
		// TODO Auto-generated method stub
		ArrayList<ItemInStore> itemForsubStore = new ArrayList<ItemInStore>();
		ArrayList<Object[]> resultSet = m_itemfacilitymappingRepo.getItemforStore(storeID);
		if(resultSet.size()>0){
			Integer[] itemID = new Integer[resultSet.size()];
			Object[] objects;
			// for (Object[] objects : resultSet)
			for (int i = 0; i < resultSet.size(); i++) {
				objects = resultSet.get(i);
				if (objects != null && objects.length >= 2) {

					itemID[i]=(Integer) objects[0];
				}

				// logger.debug("for getting state " + resultSet);
			}

			ArrayList<Object[]> quant = itemStockEntryRepo.getQuantity(itemID,storeID);

			for (Object[] objects1 : quant) {
				if (objects1 != null && objects1.length >= 2) {
					itemForsubStore.add(new ItemInStore((Integer) objects1[0], (Integer) objects1[1],(String) objects1[2],(Long) objects1[3]));
				}

				// logger.debug("for getting state " + resultSet);
			}
		}
	
		return itemForsubStore;
	};
	
	public List<ItemMaster> getItemMastersPartialSearch(String item,Integer storeID){
		List<ItemMaster> itemForsubStore = new ArrayList<ItemMaster>();
		ArrayList<Object[]> resultSet = m_itemfacilitymappingRepo.getItemforStorePartialSearch(storeID,item);
		if(resultSet.size()>0){
			Integer[] itemID = new Integer[resultSet.size()];
			Object[] objects;
			// for (Object[] objects : resultSet)
			for (int i = 0; i < resultSet.size(); i++) {
				objects = resultSet.get(i);
				if (objects != null && objects.length >= 2) {

					itemID[i]=(Integer) objects[0];
				}

				// logger.debug("for getting state " + resultSet);
			}

			itemForsubStore = itemRepo.findByItemIDIn(itemID);

			
		}
	
		return itemForsubStore;
		
	}

	@Override
	public List<ItemStockEntry> getItemBatchForStoreTransfer(Integer facFrom, Integer facTo,String item) {
		// TODO Auto-generated method stub
		List<ItemStockEntry> itemForsubStore = new ArrayList<ItemStockEntry>();
		ArrayList<Object[]> resultSet = m_itemfacilitymappingRepo.getItemforStoreLikeItemName(facFrom,item);
		if(resultSet.size()>0){
			Integer[] itemID = new Integer[resultSet.size()];
			Object[] objects;
			// for (Object[] objects : resultSet)
			for (int i = 0; i < resultSet.size(); i++) {
				objects = resultSet.get(i);
				if (objects != null && objects.length >= 2) {

					itemID[i]=(Integer) objects[0];
				}

				// logger.debug("for getting state " + resultSet);
			}
			resultSet = m_itemfacilitymappingRepo.getItemforStoreAndItemID(facTo,itemID);
			itemID = new Integer[resultSet.size()];
			for (int i = 0; i < resultSet.size(); i++) {
				objects = resultSet.get(i);
				if (objects != null && objects.length >= 2) {

					itemID[i]=(Integer) objects[0];
				}

				// logger.debug("for getting state " + resultSet);
			}
			itemForsubStore = itemStockEntryRepo.findByFacilityIDAndItemIDInAndQuantityInHandGreaterThanAndExpiryDateAfter(facFrom,itemID,0,new Date());

			
		}
		return itemForsubStore;
	}
}
