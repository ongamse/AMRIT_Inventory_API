package com.iemr.inventory.service.stockExit;

import java.util.List;

import com.iemr.inventory.data.stockExit.ItemStockExit;
import com.iemr.inventory.data.stockExit.ItemStockExitMap;
import com.iemr.inventory.data.stockExit.StoreSelfConsumption;
import com.iemr.inventory.data.stockExit.T_PatientIssue;
import com.iemr.inventory.data.stockExit.T_StockTransfer;
import com.iemr.inventory.data.stockentry.ItemStockEntryinput;
import com.iemr.inventory.utils.exception.InventoryException;

public interface StockExitService {

	Integer issuePatientDrugs(T_PatientIssue patientIssue) throws InventoryException;
	
	Integer saveItemExit(List<ItemStockExit> itemissueListUpdated, Long issueID, String issueType);
	
	List<ItemStockExit> getItemStockAndValidate(List<ItemStockExit> itemissueList, Integer facilityID,
			String createdBy,Long vanID,Long ppID);
	
	Integer storeSelfConsumption(StoreSelfConsumption storeSelfConsumption);
	
	Integer storeTransfer(T_StockTransfer stockTransfer);
	
//	 List<ItemStockEntry> getItemStockFromItemID(Integer facilityID,List<ItemStockExit> itemStockExit);
	
	List<ItemStockExitMap>  getstoreSelfConsumptionItemList( ItemStockEntryinput itemStockinput);
	
	List<ItemStockExitMap> getpatientIssueItemLIst(ItemStockEntryinput itemStockinput);
	
	List<ItemStockExitMap> getStoreTransferItemEntry(ItemStockEntryinput itemStockinput);
	
	T_PatientIssue getPatientissueAllDetail(Long patientissueID);
	
	
	
	 
	 
}
