package com.iemr.inventory.service.uom;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.uom.M_Uom;

public interface UomInter {

	ArrayList<M_Uom> createDrugtypeData(List<M_Uom> saveUomData);

	ArrayList<M_Uom> createDrugtypeData(Integer providerServiceMapID);

	M_Uom editDrugtypeData(Integer uOMID);

	M_Uom saveeditedData(M_Uom geteditedData);

}
