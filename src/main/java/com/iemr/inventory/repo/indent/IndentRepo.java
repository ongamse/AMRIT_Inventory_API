package com.iemr.inventory.repo.indent;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.inventory.data.indent.Indent;
@Repository
@RestResource(exported = false)
public interface IndentRepo extends CrudRepository<Indent, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE Indent set vanSerialNo = :indentID where indentID = :indentID and fromFacilityID = :fromFacilityID")
	public int updateVanSerialNo(@Param("indentID") Long indentID ,@Param("fromFacilityID") Integer fromFacilityID);
}
