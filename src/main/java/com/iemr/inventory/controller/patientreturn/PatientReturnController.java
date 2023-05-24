package com.iemr.inventory.controller.patientreturn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.inventory.data.patientreturn.ItemDetailModel;
import com.iemr.inventory.data.patientreturn.PatientReturnModel;
import com.iemr.inventory.data.patientreturn.ReturnHistoryModel;
import com.iemr.inventory.data.stockExit.ItemReturnEntry;
import com.iemr.inventory.data.stockExit.T_PatientIssue;
import com.iemr.inventory.service.patientreturn.PatientReturnService;
import com.iemr.inventory.utils.mapper.InputMapper;
import com.iemr.inventory.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("/patientReturnController")
@RestController
public class PatientReturnController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	PatientReturnService patientReturnService;
	
	@CrossOrigin()
	@ApiOperation(value = "get List of Item issued to Patient ",consumes = "application/json",produces = "application/json")
	@RequestMapping(value = "/getItemNameByRegID", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getItemNameByRegID(@ApiParam("{\"benRegID\":\"Integer\", \"facilityID\":\"Integer\"}") @RequestBody String input) {

		OutputResponse response = new OutputResponse();
		logger.info("getItemNameByRegID request "+input);
		try {
			T_PatientIssue patientIssue = InputMapper.gson().fromJson(input, T_PatientIssue.class);

			List<PatientReturnModel> getData = patientReturnService.getItemNameByRegID(patientIssue);

			response.setResponse(getData.toString());
		logger.info("getItemNameByRegID request "+response.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Item Details by Beneficiary",consumes = "application/json",produces = "application/json")
	@RequestMapping(value = "/getItemDetailByBen", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getItemDetailByBen(@ApiParam("{\"benRegID\":\"Integer\", \"facilityID\":\"Integer\", \"itemID\":\"Integer\"}") @RequestBody String input) {

		OutputResponse response = new OutputResponse();
		logger.info("getItemDetailByBen request "+input);
		try {
			ItemDetailModel itemDetailModel = InputMapper.gson().fromJson(input, ItemDetailModel.class);
			List<ItemDetailModel> getData = patientReturnService.getItemDetailByBen(itemDetailModel);

			response.setResponse(getData.toString());
			logger.info("getItemDetailByBen response "+response.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Item Details Returned by Patient",consumes = "application/json",produces = "application/json")
	@RequestMapping(value="/updateQuantityReturned", headers = "Authorization", method = RequestMethod.POST, produces="application/json")
	public String updateQuantityReturned(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		logger.info("updateQuantityReturned request "+request);
		try {
			ItemDetailModel[] itemDetailModel = InputMapper.gson().fromJson(request, ItemDetailModel[].class);
			String getData = patientReturnService.updateQuantityReturned(itemDetailModel);

			response.setResponse(getData.toString());
			logger.info("updateQuantityReturned response "+response.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Return History",consumes = "application/json",produces = "application/json")
	@RequestMapping(value = "/getBenReturnHistory", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getBenReturnHistory(@ApiParam("{\"benRegID\":\"Integer\", \"facilityID\":\"Integer\"}") @RequestBody String input) {

		OutputResponse response = new OutputResponse();
		logger.info("getBenReturnHistory request "+input);
		try {
			ItemReturnEntry itemReturnEntry = InputMapper.gson().fromJson(input, ItemReturnEntry.class);
			List<ReturnHistoryModel> getData = patientReturnService.getBenReturnHistory(itemReturnEntry);

			response.setResponse(getData.toString());
			logger.info("getBenReturnHistory response "+response.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
}
