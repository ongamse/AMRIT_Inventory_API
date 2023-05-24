package com.iemr.inventory.service.facilitytype;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.facilitytype.M_facilitytype;

public interface M_facilitytypeInter {

	ArrayList<M_facilitytype> getAllFicilityData(Integer providerServiceMapID);

	ArrayList<M_facilitytype> addAllFicilityData(List<M_facilitytype> addfacilityDetails);

	M_facilitytype editAllFicilityData(Integer facilityTypeID);

	M_facilitytype updateFacilityData(M_facilitytype allFacilityData);

}
