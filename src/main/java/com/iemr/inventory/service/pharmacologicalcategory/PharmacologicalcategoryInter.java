package com.iemr.inventory.service.pharmacologicalcategory;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.pharmacologicalcategory.M_Pharmacologicalcategory;

public interface PharmacologicalcategoryInter {

	ArrayList<M_Pharmacologicalcategory> createPharmacologicalcategory(
			List<M_Pharmacologicalcategory> createPharmacologicaldata);

	ArrayList<M_Pharmacologicalcategory> getPharmacologicalcategory(Integer providerServiceMapID);

	M_Pharmacologicalcategory editPharmacologicalcategory(Integer pharmCategoryID);

	M_Pharmacologicalcategory saveEditedPharData(M_Pharmacologicalcategory saveData);

}
