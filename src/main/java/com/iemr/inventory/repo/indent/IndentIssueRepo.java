package com.iemr.inventory.repo.indent;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.indent.IndentIssue;

@Repository
@RestResource(exported = false)
public interface IndentIssueRepo extends CrudRepository<IndentIssue, Long>{

	@Transactional
	@Modifying
	@Query("update IndentIssue p set p.vanSerialNo=p.indentIssueID where p.vanSerialNo is null and p.indentIssueID>0")
	void updateVanSerialNo();

}
