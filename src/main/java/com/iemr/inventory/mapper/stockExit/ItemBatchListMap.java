package com.iemr.inventory.mapper.stockExit;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.inventory.data.stockentry.ItemBatchList;
import com.iemr.inventory.data.stockentry.ItemStockEntry;

@Mapper(componentModel = "spring")
public interface ItemBatchListMap {

	ItemBatchListMap INSTANCE = Mappers.getMapper(ItemBatchListMap.class);

	@Mappings({
	      @Mapping(target="itemStockEntryID", source="itemStockExit.itemStockEntryID"),
	      @Mapping(target="facilityID", source="itemStockExit.facilityID"),
	      @Mapping(target="itemID", source="itemStockExit.itemID"),
	      @Mapping(target="quantity", source="itemStockExit.quantity"),
	      @Mapping(target="quantityInHand", source="itemStockExit.quantityInHand"),
	       @Mapping(target="batchNo", source="itemStockExit.batchNo"),
	       @Mapping(target="expiryDate", source="itemStockExit.expiryDate"),
	    })
	ItemBatchList getItemStockExitMap(ItemStockEntry itemStockExit);

	List<ItemBatchList> getItemStockExitMapList(List<ItemStockEntry> itemStockExit);
}
