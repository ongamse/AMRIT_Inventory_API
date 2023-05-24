package com.iemr.inventory.mapper.stockExit;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.inventory.data.stockExit.ItemStockExit;
import com.iemr.inventory.data.stockentry.AllocateItemMap;

@Mapper(componentModel = "spring")
public interface AllocateItemMapper {

	AllocateItemMapper INSTANCE = Mappers.getMapper(AllocateItemMapper.class);

	AllocateItemMap getItemStockExitMap(ItemStockExit itemStockExit);

	List<AllocateItemMap> getItemStockExitMapList(List<ItemStockExit> itemStockExit);
}
