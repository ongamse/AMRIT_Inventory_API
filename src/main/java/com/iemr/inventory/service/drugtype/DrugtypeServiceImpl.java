package com.iemr.inventory.service.drugtype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.drugtype.M_Drugtype;
import com.iemr.inventory.repo.drugtype.DrugtypeRepo;

@Service
public class DrugtypeServiceImpl implements DrugtypeInter{
	
	@Autowired
	private DrugtypeRepo drugtypeRepo;

	@Override
	public ArrayList<M_Drugtype> createDrugtypeData(List<M_Drugtype> drugtypeData) {
		
		ArrayList<M_Drugtype> savedData=(ArrayList<M_Drugtype>) drugtypeRepo.save(drugtypeData);
		
		if(savedData.size()>0)
			return savedData;
		else
		return null;
	}

	@Override
	public ArrayList<M_Drugtype> getDrugtypeData(Integer providerServiceMapID) {
		ArrayList<M_Drugtype> getDrugtypeData=drugtypeRepo.getDrugtypeData(providerServiceMapID);
		if(getDrugtypeData.size()>0)
			return getDrugtypeData;
		return null;
	}

	@Override
	public M_Drugtype editDrugtypeData(Integer drugTypeID) {
		
		M_Drugtype sendeditedData=drugtypeRepo.geteditedData(drugTypeID);
		return sendeditedData;
	}

	@Override
	public M_Drugtype saveeditDrugtype(M_Drugtype geteditedData) {
		M_Drugtype updateeditedData=drugtypeRepo.save(geteditedData);
		return updateeditedData;
	}

}
