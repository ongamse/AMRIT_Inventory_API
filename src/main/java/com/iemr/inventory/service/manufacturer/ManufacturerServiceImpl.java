package com.iemr.inventory.service.manufacturer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.manufacturer.M_Manufacturer;
import com.iemr.inventory.repo.manufacturer.ManufacturerRepo;

@Service
public class ManufacturerServiceImpl implements ManufacturerInter {
	
	@Autowired
	private ManufacturerRepo manufacturerRepo;

	@Override
	public ArrayList<M_Manufacturer> createManufacturer(List<M_Manufacturer> manufacturerData) {
		ArrayList<M_Manufacturer> createData=(ArrayList<M_Manufacturer>) manufacturerRepo.save(manufacturerData);
		if(createData.size()>0)
		return createData;
		else
			return null;
	}

	@Override
	public ArrayList<M_Manufacturer> createManufacturer(Integer providerServiceMapID) {
		ArrayList<M_Manufacturer> getData=manufacturerRepo.getManufacturerData(providerServiceMapID);
		
		if(getData.size()>0)	
		return getData;
		else
			return null;
	}

	@Override
	public M_Manufacturer editManufacturer(Integer manufacturerID) {
		
		M_Manufacturer edit=manufacturerRepo.getEditData(manufacturerID);
		return edit;
	}

	@Override
	public M_Manufacturer saveEditedData(M_Manufacturer editData) {
		M_Manufacturer data=manufacturerRepo.save(editData);
		
		return data;
	}

}
