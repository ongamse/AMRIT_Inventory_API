package com.iemr.inventory.repository.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.items.ItemMaster;

@Repository
@RestResource(exported = false)
public interface ItemRepo extends CrudRepository<ItemMaster, Integer> {

	List<ItemMaster> findByProviderServiceMapID(Integer providerServiceMapID);

	List<ItemMaster> findByDeletedAndProviderServiceMapID(Boolean deleted, Integer providerServiceMapID);

	@Transactional
	@Modifying
	@Query("UPDATE ItemMaster c SET c.deleted = :flag WHERE c.itemID = :itemid")
	Integer deleteItemMaster(@Param("itemid")Integer id,@Param("flag")Boolean flag);

	@Transactional
	@Modifying
	@Query("UPDATE ItemMaster c SET c.discontinued = :flag WHERE c.itemID = :itemid")
	Integer discontinueItemMaster(@Param("itemid")Integer id,@Param("flag")Boolean flag);
   
	
	@Query("SELECT u FROM ItemMaster u WHERE u.providerServiceMapID=:providerServiceMapID AND u.itemCategoryID=:itemCategoryID AND deleted=0")
	List<ItemMaster> getItemMasters(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("itemCategoryID") Integer itemCategoryID);

	@Query("select u from ItemMaster u  where u.itemID=:itemid")
	ItemMaster findDetailOne(@Param("itemid")Integer itemid);
	
	List<ItemMaster> findByItemNameLikeOrItemCodeLike(String itemName,String itemCode);
	
	List<ItemMaster> findByItemNameContainingAndItemIDIn(String itemname,Integer[] itemids);
	
	List<ItemMaster> findByItemIDIn(Integer[] itemids);
	
	
}
