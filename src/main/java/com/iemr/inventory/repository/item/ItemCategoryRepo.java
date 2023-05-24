package com.iemr.inventory.repository.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.items.M_ItemCategory;

@Repository
@RestResource(exported = false)
public interface ItemCategoryRepo extends CrudRepository<M_ItemCategory, Integer>  {
	
	List<M_ItemCategory> findByDeletedAndProviderServiceMapID(Boolean deleted,Integer providerServiceMapID);
	
	List<M_ItemCategory> findByProviderServiceMapID (Integer providerServiceMapID);
	
	@Transactional
	@Modifying
	@Query("UPDATE M_ItemCategory c SET c.issueType = :issuetype WHERE c.itemCategoryID = :id")
	Integer updateIssueConfig(@Param("id")Integer id,@Param("issuetype")String issuetype);
}
