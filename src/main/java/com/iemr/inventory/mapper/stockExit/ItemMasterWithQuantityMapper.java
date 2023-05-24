package com.iemr.inventory.mapper.stockExit;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.inventory.data.stockentry.ItemMasterWithQuantityMap;
import com.iemr.inventory.data.stockentry.ItemStockEntry;

@Mapper(componentModel = "spring")
public interface ItemMasterWithQuantityMapper {

	ItemMasterWithQuantityMapper INSTANCE = Mappers.getMapper(ItemMasterWithQuantityMapper.class);
	
	 
	 ItemMasterWithQuantityMap getItemStockExitMap(ItemStockEntry itemStockExit);
	
	List<ItemMasterWithQuantityMap> getItemStockExitMapList(List<ItemStockEntry> itemStockExit);
}
