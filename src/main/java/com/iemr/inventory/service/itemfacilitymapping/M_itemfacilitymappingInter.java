package com.iemr.inventory.service.itemfacilitymapping;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.itemfacilitymapping.M_itemfacilitymapping;
import com.iemr.inventory.data.itemfacilitymapping.V_fetchItemFacilityMap;
import com.iemr.inventory.data.items.ItemInStore;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.stockentry.ItemStockEntry;

public interface M_itemfacilitymappingInter{

	ArrayList<M_itemfacilitymapping> mapItemtoStore(List<M_itemfacilitymapping> resList);

	M_itemfacilitymapping editdata(Integer itemStoreMapID);

	M_itemfacilitymapping saveEditedItem(M_itemfacilitymapping getdataforedit);

	ArrayList<M_itemfacilitymapping> getsubitemforsubStote(Integer providerServiceMapID, Integer facilityID);

	ArrayList<V_fetchItemFacilityMap> getAllFacilityMappedData(Integer providerServiceMapID);
	
	List<ItemInStore> getItemMastersFromStoreID(Integer storeID);
	
	List<ItemMaster> getItemMastersPartialSearch(String item,Integer storeID);
	

	List<ItemStockEntry> getItemBatchForStoreTransfer(Integer facFrom,Integer facTo,String item);
}
