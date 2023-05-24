package com.iemr.inventory.service.supplier;

import java.util.ArrayList;
import java.util.List;

import com.iemr.inventory.data.supplier.M_Supplier;
import com.iemr.inventory.data.supplier.M_Supplieraddress;

public interface SupplierInter {

	ArrayList<M_Supplier> createSupplier(List<M_Supplier> supplierData);

	ArrayList<M_Supplier> getSupplier(Integer providerServiceMapID);

	M_Supplier editSupplier(Integer supplierID);

	M_Supplier saveEditedData(M_Supplier editData);

	ArrayList<M_Supplieraddress> createAddress(List<M_Supplieraddress> resList1);

}
