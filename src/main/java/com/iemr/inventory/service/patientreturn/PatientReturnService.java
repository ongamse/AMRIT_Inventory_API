package com.iemr.inventory.service.patientreturn;

import java.util.List;

import com.iemr.inventory.data.patientreturn.ItemDetailModel;
import com.iemr.inventory.data.patientreturn.PatientReturnModel;
import com.iemr.inventory.data.patientreturn.ReturnHistoryModel;
import com.iemr.inventory.data.stockExit.ItemReturnEntry;
import com.iemr.inventory.data.stockExit.T_PatientIssue;

public interface PatientReturnService {

	List<PatientReturnModel> getItemNameByRegID(T_PatientIssue patientIssue);

	List<ItemDetailModel> getItemDetailByBen(ItemDetailModel itemDetailModel);

	String updateQuantityReturned(ItemDetailModel[] itemDetailModel);

	List<ReturnHistoryModel> getBenReturnHistory(ItemReturnEntry itemReturnEntry);
}
