package com.iemr.inventory.service.stockEntry;

import java.util.Date;
import java.util.List;

import com.iemr.inventory.data.stockExit.ItemStockExit;
import com.iemr.inventory.data.stockentry.AllocateItemMap;
import com.iemr.inventory.data.stockentry.ItemMasterWithQuantityMap;
import com.iemr.inventory.data.stockentry.ItemStockEntry;
import com.iemr.inventory.data.stockentry.PhysicalStockEntry;
import com.iemr.inventory.utils.exception.InventoryException;

public interface StockEntryService {

	PhysicalStockEntry savePhysicalStockEntry(PhysicalStockEntry physicalStockEntry) throws Exception;

	List<ItemStockEntry> getItemBatchForStoreID(ItemStockEntry itemStockEntry);

	List<Object[]> getAllItemBatchForStoreID(Integer storeID, Long[] itemStockID);

	Integer updateStocks(List<ItemStockExit> itemissueListUpdated);

	List<ItemStockEntry> getItemStockForStoreIDOrderByEntryDateAsc(Integer facilityID, Integer itemID, Date nowdate);

	List<ItemStockEntry> getItemStockForStoreIDOrderByEntryDateDesc(Integer facilityID, Integer itemID, Date nowdate);

	List<ItemStockEntry> getItemStockForStoreIDOrderByExpiryDateAsc(Integer facilityID, Integer itemID, Date nowdate);

	List<AllocateItemMap> getItemStockFromItemID(Integer facilityID, List<ItemStockExit> itemStockExitList) throws InventoryException;

	List<ItemStockEntry> saveItemStockFromStockTransfer(List<ItemStockExit> itemStock, Long insertID,
			String insertType, Integer facilityFromID, Integer facilityToID,Long tovanID);

	List<ItemStockEntry> getItemMastersPartialSearch(String itemName, Integer facilityID);

	List<ItemStockEntry> getPhysicalStockEntryItems(Long phySEID);

	List<ItemMasterWithQuantityMap> getItemwithQuantityPartialSearch(String itemName, Integer facilityID);
}
