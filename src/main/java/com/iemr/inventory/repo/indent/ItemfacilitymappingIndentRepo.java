package com.iemr.inventory.repo.indent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.indent.ItemfacilitymappingIndent;

@Repository
@RestResource(exported = false)
public interface ItemfacilitymappingIndentRepo extends CrudRepository<ItemfacilitymappingIndent, Integer> {

	

	@Query(nativeQuery = true, value="select iti.ItemID,iti.ItemCode, iti.ItemName,iti.IsMedical,iti.Strength,"
			+ "uom.UOMName,itcat.ItemCategoryName,itemform.ItemFormName,pharm.PharmCategoryName "
			+ ",iti.Composition,u.FacilityID,sum(ise.quantityInHand) as qoh "
			+ "from m_itemfacilitymapping u "
			+ "left join t_itemstockentry ise on ise.itemid=u.itemid and ise.FacilityID=:facID and ise.ExpiryDate>now()"
			+ "inner join m_item iti  on iti.itemid=u.itemid "
			+ "left join m_itemcategory itcat on itcat.ItemCategoryID=iti.ItemCategoryID "
			+ "left join m_itemform itemform on itemform.ItemFormID=iti.ItemFormID "
			+ "left join m_pharmacologicalcategory pharm on pharm.PharmCategoryID=iti.PharmacologyCategoryID "
			+ "left join m_uom uom on uom.UOMID=iti.UOMID "
			+ "where u.facilityID=:facID and (iti.itemName like %:itemNamep% or iti.itemCode like %:itemNamep%) "
			+ "  and iti.Deleted=false and iti.Discontinued=false "
			+ " and u.deleted=false "
			+ " group by u.itemID,u.facilityID order by iti.ItemName")
	List<Object[]> findindentitem(@Param("facID")Integer facilityID,@Param("itemNamep") String itemName);



}
