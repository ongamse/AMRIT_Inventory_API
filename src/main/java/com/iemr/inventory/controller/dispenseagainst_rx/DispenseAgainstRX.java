package com.iemr.inventory.controller.dispenseagainst_rx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.inventory.service.dispenseagainst_rx.DispenseAgainstRXimpl;
import com.iemr.inventory.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/RX", headers = "Authorization")
public class DispenseAgainstRX {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private DispenseAgainstRXimpl dispenseAgainstRXimpl;

	@CrossOrigin()
	@ApiOperation(value = "get prescribed medicine list by doctor", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "getPrescribedMedicines", method = RequestMethod.POST)
	public String getPrescribedMedicinesToDispense(@RequestBody String requestOBJ) {
		OutputResponse response = new OutputResponse();
		try {
			if (requestOBJ != null) {
				String s = dispenseAgainstRXimpl.getPrescribedMedicines(requestOBJ);

				if (s != null) {
					response.setResponse(s);
				}
			} else {
				response.setError(5000, "Invalid request");
			}

		} catch (Exception e) {
			logger.error("exception occured while fetching prescribed medicines", e);
			response.setError(e);
		}
		return response.toString();
	}

}
