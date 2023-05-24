package com.iemr.inventory.service.drugtype;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.drugtype.M_Drugtype;

public interface DrugtypeInter {

	ArrayList<M_Drugtype> createDrugtypeData(List<M_Drugtype> drugtypeData);

	ArrayList<M_Drugtype> getDrugtypeData(Integer providerServiceMapID);

	M_Drugtype editDrugtypeData(Integer drugTypeID);

	M_Drugtype saveeditDrugtype(M_Drugtype geteditedData);

}
