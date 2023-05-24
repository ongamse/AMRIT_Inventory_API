package com.iemr.inventory.service.indent;

import java.util.List;

import com.iemr.inventory.data.indent.Indent;
import com.iemr.inventory.data.indent.IndentIssue;
import com.iemr.inventory.data.indent.IndentOrder;
import com.iemr.inventory.data.indent.ItemfacilitymappingIndent;

public interface IndentService {

	List<ItemfacilitymappingIndent> findItemIndent(Integer facilityID, String itemName);
	
	String createIndentRequest(Indent indent);

	String getIndentHistory(Indent indent);
	
	String getOrdersByIndentID(IndentOrder indentOrder);
	
	String getIndentWorklist(IndentOrder indentOrder);

	String getIndentOrderWorklist(IndentOrder indentOrder);

	String issueIndent(IndentIssue[] array);

	String cancelIndentOrder(Indent indent);

	String receiveIndent(Indent indent);

	String updateIndentOrder(Indent indent);







	

	

	

}
