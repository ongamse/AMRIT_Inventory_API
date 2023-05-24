package com.iemr.inventory.repo.dispenseagainst_rx;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.dispenseagainst_rx.PrescribedDrugDetails;

@Repository
@RestResource(exported = false)
public interface PrescribedDrugDetailsRepo extends CrudRepository<PrescribedDrugDetails, Long> {
	@Query(" SELECT Distinct beneficiaryRegID, visitCode, prescriptionID, drugID, genericDrugName, drugForm,"
			+ " drugStrength, dose, route, frequency, "
			+ " duration, duartionUnit, relationToFood, specialInstruction, createdDate, createdBy, "
			+ " itemStockEntryID, batchNo, quantityInHand, expiryDate, qtyPrescribed, isEDL  "
			+ " FROM PrescribedDrugDetails  WHERE beneficiaryRegID =:benRegID "
			+ " AND visitCode =:visitCode AND (facilityID =:facilityID or facilityID is null) ORDER BY drugID, createdDate DESC ")
	ArrayList<Object[]> getPrescribedMedicinesWithDetails(@Param("benRegID") Long benRegID,
			@Param("visitCode") Long visitCode, @Param("facilityID") Integer facilityID);

}
