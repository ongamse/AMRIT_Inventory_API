package com.iemr.inventory.service.manufacturer;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.manufacturer.M_Manufacturer;

public interface ManufacturerInter {

	ArrayList<M_Manufacturer> createManufacturer(List<M_Manufacturer> manufacturerData);

	ArrayList<M_Manufacturer> createManufacturer(Integer providerServiceMapID);

	M_Manufacturer editManufacturer(Integer manufacturerID);

	M_Manufacturer saveEditedData(M_Manufacturer editData);
	

}
