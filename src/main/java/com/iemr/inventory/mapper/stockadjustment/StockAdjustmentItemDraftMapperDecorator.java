package com.iemr.inventory.mapper.stockadjustment;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.stockadjustment.StockAdjustmentItem;
import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraft;
import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraftEdit;
import com.iemr.inventory.data.stockentry.ItemStockEntry;

public abstract class StockAdjustmentItemDraftMapperDecorator implements StockAdjustmentItemDraftMapper {

	public StockAdjustmentItemDraftEdit getStockAdjustmentItemDraftEdit(
			StockAdjustmentItemDraft stockAdjustmentItemDraftEdit) {

		StockAdjustmentItemDraftEdit saItemDraftEdit = new StockAdjustmentItemDraftEdit();
		if (stockAdjustmentItemDraftEdit != null) {
			saItemDraftEdit.setSADraftItemMapID(stockAdjustmentItemDraftEdit.getSADraftItemMapID());
			saItemDraftEdit.setItemStockEntryID(stockAdjustmentItemDraftEdit.getItemStockEntryID());
			if (stockAdjustmentItemDraftEdit.getItemStockEntry() != null) {
				ItemStockEntry itemStockEntry = stockAdjustmentItemDraftEdit.getItemStockEntry();
				saItemDraftEdit.setBatchID(itemStockEntry.getBatchNo());
				if (itemStockEntry.getItem() != null) {
					saItemDraftEdit.setItemName(itemStockEntry.getItem().getItemName());
				}

				saItemDraftEdit.setQuantityInHand(itemStockEntry.getQuantityInHand());
			}

			saItemDraftEdit.setAdjustedQuantity(stockAdjustmentItemDraftEdit.getAdjustedQuantity());
			saItemDraftEdit.setCreatedBy(stockAdjustmentItemDraftEdit.getCreatedBy());
			saItemDraftEdit.setProviderServiceMapID(stockAdjustmentItemDraftEdit.getProviderServiceMapID());
			saItemDraftEdit.setIsAdded(stockAdjustmentItemDraftEdit.getIsAdded());
			saItemDraftEdit.setDeleted(stockAdjustmentItemDraftEdit.getDeleted());
			saItemDraftEdit.setReason(stockAdjustmentItemDraftEdit.getReason());

		}
		return saItemDraftEdit;
	}

	public List<StockAdjustmentItemDraftEdit> getStockAdjustmentItemDraftEditList(
			List<StockAdjustmentItemDraft> stockAdjustmentItemDraftEdit) {

		List<StockAdjustmentItemDraftEdit> stockAdjustmentItemDraftEditlist = new ArrayList<StockAdjustmentItemDraftEdit>();

		stockAdjustmentItemDraftEdit.stream().forEach(action -> {
			if(action!=null && !action.getDeleted()){
				stockAdjustmentItemDraftEditlist.add(getStockAdjustmentItemDraftEdit(action));
			}
		});

		return stockAdjustmentItemDraftEditlist;

	}

	public StockAdjustmentItemDraftEdit getStockAdjustmentItemEdit(StockAdjustmentItem stockAdjustmentItemDraftEdit) {

		StockAdjustmentItemDraftEdit saItemDraftEdit = new StockAdjustmentItemDraftEdit();
		if (stockAdjustmentItemDraftEdit != null) {
			saItemDraftEdit.setSAItemMapID(stockAdjustmentItemDraftEdit.getSAItemMapID());
			saItemDraftEdit.setItemStockEntryID(stockAdjustmentItemDraftEdit.getItemStockEntryID());
			if (stockAdjustmentItemDraftEdit.getItemStockEntry() != null) {
				ItemStockEntry itemStockEntry = stockAdjustmentItemDraftEdit.getItemStockEntry();
				saItemDraftEdit.setBatchID(itemStockEntry.getBatchNo());
				if (itemStockEntry.getItem() != null) {
					saItemDraftEdit.setItemName(itemStockEntry.getItem().getItemName());
				}

				saItemDraftEdit.setQuantityInHand(itemStockEntry.getQuantityInHand());
			}

			saItemDraftEdit.setAdjustedQuantity(stockAdjustmentItemDraftEdit.getAdjustedQuantity());
			saItemDraftEdit.setCreatedBy(stockAdjustmentItemDraftEdit.getCreatedBy());
			saItemDraftEdit.setProviderServiceMapID(stockAdjustmentItemDraftEdit.getProviderServiceMapID());
			saItemDraftEdit.setIsAdded(stockAdjustmentItemDraftEdit.getIsAdded());
			saItemDraftEdit.setDeleted(stockAdjustmentItemDraftEdit.getDeleted());
			saItemDraftEdit.setReason(stockAdjustmentItemDraftEdit.getReason());
		}
		return saItemDraftEdit;
	}

	public List<StockAdjustmentItemDraftEdit> getStockAdjustmentItemEditList(
			List<StockAdjustmentItem> stockAdjustmentItemDraftEdit) {

		List<StockAdjustmentItemDraftEdit> stockAdjustmentItemDraftEditlist = new ArrayList<StockAdjustmentItemDraftEdit>();

		stockAdjustmentItemDraftEdit.stream().forEach(action -> {
			stockAdjustmentItemDraftEditlist.add(getStockAdjustmentItemEdit(action));
		});

		return stockAdjustmentItemDraftEditlist;

	}
}
