package com.iemr.inventory.mapper.stockExit;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.inventory.data.stockExit.ItemStockExit;
import com.iemr.inventory.data.stockExit.ItemStockExitMap;
import com.iemr.inventory.data.stockentry.ItemStockEntry;

@Mapper(componentModel = "spring")
public interface ItemStockExitMapper {

	ItemStockExitMapper INSTANCE = Mappers.getMapper(ItemStockExitMapper.class);
	
	 @Mappings({
	      @Mapping(target="itemName", source="itemStockExit.itemStockEntry.item.itemName"),
	      @Mapping(target="batchNo", source="itemStockExit.itemStockEntry.batchNo"),
	      @Mapping(target="expiryDate", source="itemStockExit.itemStockEntry.expiryDate"), 
	      @Mapping(target="createdDate", source="itemStockExit.createdDate"),
	      @Mapping(target="createdBy", source="itemStockExit.createdBy"),
	      @Mapping(target="quantity", source="itemStockExit.quantity"),
	       @Mapping(target="deleted", source="itemStockExit.deleted"),
	    })
	ItemStockExitMap getItemStockExitMap(ItemStockExit itemStockExit);
	
	List<ItemStockExitMap> getItemStockExitMapList(List<ItemStockExit> itemStockExit);

	 @Mappings({
	      @Mapping(target="itemName", source="itemStockEntry.item.itemName"),
	      @Mapping(target="batchNo", source="itemStockEntry.batchNo"),
	      @Mapping(target="expiryDate", source="itemStockEntry.expiryDate"), 
	      @Mapping(target="createdDate", source="itemStockEntry.createdDate"),
	      @Mapping(target="createdBy", source="itemStockEntry.createdBy"),
	      @Mapping(target="quantity", source="itemStockEntry.quantity"),
	       @Mapping(target="deleted", source="itemStockEntry.deleted"),
	    })
	ItemStockExitMap getItemStockEntryMapList(ItemStockEntry itemStockEntry);
	 
	List<ItemStockExitMap> getItemStockEntryMapList(List<ItemStockEntry> itemStockEntry);
}
