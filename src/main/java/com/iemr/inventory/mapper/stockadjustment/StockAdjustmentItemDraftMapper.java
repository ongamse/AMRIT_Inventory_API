package com.iemr.inventory.mapper.stockadjustment;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.inventory.data.stockadjustment.StockAdjustmentItem;
import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraft;
import com.iemr.inventory.data.stockadjustment.StockAdjustmentItemDraftEdit;

@Mapper(componentModel = "spring")
@DecoratedWith(StockAdjustmentItemDraftMapperDecorator.class)
public interface StockAdjustmentItemDraftMapper {
	StockAdjustmentItemDraftMapper INSTANCE = Mappers.getMapper(StockAdjustmentItemDraftMapper.class);

	StockAdjustmentItemDraftEdit getStockAdjustmentItemDraftEdit(StockAdjustmentItemDraft stockAdjustmentItemDraftEdit);

	List<StockAdjustmentItemDraftEdit> getStockAdjustmentItemDraftEditList(
			List<StockAdjustmentItemDraft> stockAdjustmentItemDraftEdit);

	StockAdjustmentItemDraftEdit getStockAdjustmentItemEdit(StockAdjustmentItem stockAdjustmentItemDraftEdit);

	List<StockAdjustmentItemDraftEdit> getStockAdjustmentItemEditList(
			List<StockAdjustmentItem> stockAdjustmentItemDraftEdit);

}
