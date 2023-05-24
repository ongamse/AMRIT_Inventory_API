package com.iemr.inventory.service.facilitytype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.inventory.data.facilitytype.M_facilitytype;
import com.iemr.inventory.repository.facilitytype.M_facilitytypeRepo;

@Service
public class M_facilitytypeServiceImpl implements M_facilitytypeInter{

	@Autowired
	private M_facilitytypeRepo m_facilitytypeRepo;

	@Override
	public ArrayList<M_facilitytype> getAllFicilityData(Integer providerServiceMapID) {
		ArrayList<M_facilitytype> data=m_facilitytypeRepo.getAllFicilityData(providerServiceMapID);
		return data;
	}

	@Override
	public ArrayList<M_facilitytype> addAllFicilityData(List<M_facilitytype> addfacilityDetails) {
		ArrayList<M_facilitytype> data=(ArrayList<M_facilitytype>) m_facilitytypeRepo.save(addfacilityDetails);
		return data;
	}

	@Override
	public M_facilitytype editAllFicilityData(Integer facilityTypeID) {
		M_facilitytype data=m_facilitytypeRepo.findOne(facilityTypeID); 
		return data;
	}

	@Override
	public M_facilitytype updateFacilityData(M_facilitytype allFacilityData) {
		M_facilitytype data=m_facilitytypeRepo.save(allFacilityData);
		return data;
	}

}
