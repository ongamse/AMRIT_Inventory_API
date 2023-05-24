package com.iemr.inventory.repository.itemfacilitymapping;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.itemfacilitymapping.M_itemfacilitymapping;

@Repository
@RestResource(exported = false)
public interface M_itemfacilitymappingRepo extends CrudRepository<M_itemfacilitymapping, Integer>{
	
	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName, "
			  + " imfm.discontinued as discontinued,"
			  + " imfm.itemCategoryID as itemCategoryID "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.providerServiceMapID =:providerServiceMapID AND mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.deleted=0 ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforSubstore(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("facilityID") Integer facilityID);
	
	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.deleted=0 ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforStore(@Param("facilityID") Integer facilityID);
	
	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.deleted=0 AND (imfm.itemName Like %:itemName% OR imfm.itemCode Like %:itemName%) ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforStoreLikeItemName(@Param("facilityID") Integer facilityID,@Param("itemName")String itemName);
	
	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.facilityID=:facilityID AND mi.itemID in (:itemIDs) AND mi.deleted=0 AND imfm.deleted=0 ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforStoreAndItemID(@Param("facilityID") Integer facilityID,@Param("itemIDs") Integer[] itemIDs);

	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.discontinued=0 AND imfm.deleted=0 AND (imfm.itemName Like %:itemName% OR imfm.itemCode Like %:itemName%)  ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforStorePartialSearch(@Param("facilityID") Integer facilityID,@Param("itemName") String itemName);
	
	
}
