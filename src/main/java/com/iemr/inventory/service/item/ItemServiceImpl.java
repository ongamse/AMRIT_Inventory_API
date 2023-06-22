/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.inventory.service.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.itemfacilitymapping.M_itemfacilitymapping;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.items.M_ItemCategory;
import com.iemr.inventory.data.items.M_ItemForm;
import com.iemr.inventory.data.items.M_Route;
import com.iemr.inventory.repository.item.ItemCategoryRepo;
import com.iemr.inventory.repository.item.ItemFormRepo;
import com.iemr.inventory.repository.item.ItemRepo;
import com.iemr.inventory.repository.item.RouteRepo;
import com.iemr.inventory.repository.itemfacilitymapping.M_itemfacilitymappingRepo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private ItemCategoryRepo itemCategoryRepo;

	@Autowired
	private RouteRepo routeRepo;

	@Autowired
	private ItemFormRepo itemFormRepo;

	@Autowired
	M_itemfacilitymappingRepo itemfacilitymappingRepo;
	
	@Override
	public ItemMaster createItemMaster(ItemMaster itemMaster) {
		// TODO Auto-generated method stub
		return itemRepo.save(itemMaster);
	}

	public List<M_ItemCategory> getItemCategory(Boolean all, Integer providerServiceMapID) {
		// TODO Auto-generated method stub
		List<M_ItemCategory> itemCategory = new ArrayList<M_ItemCategory>();
		if (providerServiceMapID != null) {
			if (all) {
				itemCategory = itemCategoryRepo.findByProviderServiceMapID(providerServiceMapID);
			} else {
				itemCategory = itemCategoryRepo.findByDeletedAndProviderServiceMapID(false, providerServiceMapID);
			}
		}
		return itemCategory;
	}

	public List<M_Route> getItemRoute(Boolean all) {
		// TODO Auto-generated method stub

		List<M_Route> route = new ArrayList<M_Route>();

		if (all) {
			route = routeRepo.getAll();
		} else {
			route = routeRepo.findByDeleted(false);
		}

		return route;
	}

	public List<M_ItemForm> getItemForm(Boolean all) {
		// TODO Auto-generated method stub

		List<M_ItemForm> route = new ArrayList<M_ItemForm>();

		if (all) {
			route = itemFormRepo.getAll();
		} else {
			route = itemFormRepo.findByDeleted(false);
		}

		return route;
	}

	public List<ItemMaster> getItemMaster(Integer providerServiceMapID) {

		return itemRepo.findByProviderServiceMapID(providerServiceMapID);

	}

	public Integer blockItemMaster(Integer itemmasterID, Boolean deleteflag) {
		return itemRepo.deleteItemMaster(itemmasterID, deleteflag);

	};

	public Integer discontinueItemMaster(Integer itemmasterID, Boolean continueflag) {
		return itemRepo.discontinueItemMaster(itemmasterID, continueflag);

	}

	@Override
	public List<ItemMaster> addAllItemMaster(List<ItemMaster> itemMaster) {
		// TODO Auto-generated method stub
		return (List<ItemMaster>) itemRepo.save(itemMaster);
	}

//	@Override
//	public List<M_ItemIssueConfig> addAllItemIssueConfig(List<M_ItemIssueConfig> itemMaster) {
//		// TODO Auto-generated method stub
//		return (List<M_ItemIssueConfig>) itemIssueRepo.save(itemMaster);
//	};
//
//	public M_ItemIssueConfig updateItemIssueConfig(M_ItemIssueConfig itemMaster) {
//		// TODO Auto-generated method stub
//		return (M_ItemIssueConfig) itemIssueRepo.save(itemMaster);
//	}
//
//	@Override
//	public M_ItemIssueConfig findItemIssueConfig(Integer itemIssueConfigID) {
//		// TODO Auto-generated method stub
//		return itemIssueRepo.findOne(itemIssueConfigID);
//	}
//
//	@Override
//	public List<M_ItemIssueConfig> findItemIssueConfigProviderServiceMapID(Integer providerServiceMapID) {
//		// TODO Auto-generated method stub
//		return itemIssueRepo.findByProviderServiceMapID(providerServiceMapID);
//	}

	@Override
	public ItemMaster getItemMasterByID(Integer itemMasterID) {
		// TODO Auto-generated method stub
		
		return itemRepo.findOne(itemMasterID);
	}

	public ItemMaster getItemMasterCatByID(Integer itemMasterID) {
		// TODO Auto-generated method stub
		
		return itemRepo.findDetailOne(itemMasterID);
	}
	@Override
	public Integer updateItemIssueConfig(List<M_ItemCategory> itemCategory) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (M_ItemCategory m_ItemCategory : itemCategory) {
			if (m_ItemCategory.getItemCategoryID()!=null && m_ItemCategory.getIssueType() != null) {
				cnt = cnt + itemCategoryRepo.updateIssueConfig(m_ItemCategory.getItemCategoryID(),m_ItemCategory.getIssueType());
			}
		}
		return cnt;
	}

	@Override
	public List<M_Route> getItemRouteProviderServiceMapID(Integer providerServiceMapID) {
		// TODO Auto-generated method stub
		return routeRepo.findByProviderServiceMapID(providerServiceMapID);
	}

	@Override
	public List<M_ItemForm> getItemFormProviderServiceMapID(Integer providerServiceMapID) {
		// TODO Auto-generated method stub

		return itemFormRepo.findByProviderServiceMapID(providerServiceMapID);
	
	}
	@Override
	public List<ItemMaster> getItemMasters(Integer providerServiceMapID, Integer itemCategoryID) {
		List<ItemMaster>  data=itemRepo.getItemMasters(providerServiceMapID,itemCategoryID);
		return data;

	}

	@Override
	public M_ItemCategory getItemCategory(Integer catID) {
		// TODO Auto-generated method stub
		return itemCategoryRepo.findOne(catID);
	}

	@Override
	public List<ItemMaster> getActiveItemMaster(ItemMaster itemMaster) {
		// TODO Auto-generated method stub
		return itemRepo.findByDeletedAndProviderServiceMapID(itemMaster.getDeleted(), itemMaster.getProviderServiceMapID());
	}	
}
