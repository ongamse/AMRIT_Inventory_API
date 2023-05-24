package com.iemr.inventory.repo.stockExit;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.inventory.data.stockExit.T_PatientIssue;

@Repository
@RestResource(exported = false)
public interface PatientIssueRepo extends CrudRepository<T_PatientIssue, Long> {

	List<T_PatientIssue> findByFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Integer faciilityID,
			Timestamp fromDate, Timestamp toDate);

	@Transactional
	@Modifying
	@Query(value = " UPDATE db_iemr.i_ben_flow_outreach SET pharmacist_flag = 9, Processed = 'U' "
			+ " WHERE beneficiary_reg_id = :benRegID AND beneficiary_visit_code = :benVisitCode ", nativeQuery = true)
	public int updateBenStatusFlowAfterPharma(@Param("benRegID") Long benRegID,
			@Param("benVisitCode") Long benVisitCode);
	
	@Transactional
	@Modifying
	@Query("update T_PatientIssue p set p.vanSerialNo=p.patientIssueID where p.vanSerialNo is null and p.patientIssueID>0")
	Integer updateVanSerialNo();
}
