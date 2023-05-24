package com.iemr.inventory.service.report;

import com.iemr.inventory.data.report.ItemStockEntryReport;
import com.iemr.inventory.data.report.ItemStockExitReport;
import com.iemr.inventory.data.report.PatientIssueExitReport;

public interface CRMReportService {

	String getInwardStockReport(ItemStockEntryReport itemStockEntryReport);

	String getExpiryReport(ItemStockEntryReport entryReport);

	String getConsumptionReport(ItemStockExitReport exitReport);

	String getBenDrugIssueReport(PatientIssueExitReport exitReport);

	String getDailyStockSummaryReport(ItemStockEntryReport entryReport);

	String getDailyStockDetailsReport(ItemStockEntryReport entryReport);

	String getYearlyReport(ItemStockEntryReport entryReport);

	String getMonthlyReport(ItemStockEntryReport entryReport);

	String getShortExpiryReport(ItemStockEntryReport entryReport);

	String getTransitReport(ItemStockEntryReport entryReport);
}
