package com.iemr.inventory.service.uom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.uom.M_Uom;
import com.iemr.inventory.repo.uom.UomRepo;

@Service
public class UomServiceImpl implements UomInter {
	
	@Autowired
	private UomRepo uomRepo;

	@Override
	public ArrayList<M_Uom> createDrugtypeData(List<M_Uom> saveUomData) {
		
		ArrayList<M_Uom> saveData=(ArrayList<M_Uom>) uomRepo.save(saveUomData);
		if(saveData.size()>0)
			return saveData;
		return null;
	}

	@Override
	public ArrayList<M_Uom> createDrugtypeData(Integer providerServiceMapID) {
		ArrayList<M_Uom> getUomData=uomRepo.getUom(providerServiceMapID);
		if(getUomData.size()>0)
		return getUomData;
		else
			return null;
	}

	@Override
	public M_Uom editDrugtypeData(Integer uOMID) {
		M_Uom geteditedData=uomRepo.geteditedData(uOMID);
		return geteditedData;
	}

	@Override
	public M_Uom saveeditedData(M_Uom geteditedData) {
		M_Uom saveeditedData=uomRepo.save(geteditedData);
		return saveeditedData;
	}
	

}
