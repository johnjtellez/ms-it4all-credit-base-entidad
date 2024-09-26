package com.it4all.credit.admon.data.model.repository.businessrulesparameters;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it4all.credit.admon.data.model.BusinessRulesParameter;

public interface BusinessRulesParameterRepository extends
	JpaRepository<BusinessRulesParameter, Long>, JpaSpecificationExecutor<BusinessRulesParameter> {

	@Query("SELECT a FROM BusinessRulesParameter a ")
	List<BusinessRulesParameter> getByPage(Pageable pageable);

    @Query("SELECT a FROM BusinessRulesParameter a "
        + "LEFT JOIN a.businessRulesIdEntity "
        + "WHERE a.businessRulesId = :businessRulesId")
    List<BusinessRulesParameter> findByIdWithBusinessRules(
        @Param("businessRulesId") Long businessRulesId);

    @Query("SELECT a FROM BusinessRulesParameter a "
        + "LEFT JOIN a.businessRulesIdEntity ")
    List<BusinessRulesParameter> findAllWithBusinessRules();

    @Query("SELECT a FROM BusinessRulesParameter a "
        + "LEFT JOIN a.businessRulesIdEntity ")
    List<BusinessRulesParameter> getByPageWithBusinessRules(
    		Pageable pageable);

    @Query("SELECT a FROM BusinessRulesParameter a "
        + "LEFT JOIN a.businessRulesIdEntity ")
    List<BusinessRulesParameter> findAllWithBusinessRules(
    		Specification<BusinessRulesParameter> spec,
    		Pageable pageable);

    @Query("SELECT b FROM BusinessRulesParameter b "
            + " WHERE b.businessRulesId = :businessRulesId ")
    List<BusinessRulesParameter> findByBusinessRulesId(
    		@Param("businessRulesId") Long businessRulesId);
}
