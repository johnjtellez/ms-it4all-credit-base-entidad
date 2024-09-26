package com.it4all.credit.admon.data.model.repository.businessrules;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it4all.credit.admon.data.model.BusinessRules;

public interface BusinessRulesRepository extends JpaRepository<BusinessRules, Long>, JpaSpecificationExecutor<BusinessRules> {

	@Query("SELECT a FROM BusinessRules a")
	List<BusinessRules> getByPage(
			Pageable pageable);

	@Query("SELECT b FROM BusinessRules b " +         
			" WHERE b.code = :code " +                
			" AND b.isEnabled = true " +              
			" AND b.nameField = :nameField")          
		List<BusinessRules> getRuleByCodeAndField(    
				@Param("code") String code,           
				@Param("nameField") String nameField);
}
