package com.it4all.credit.admon.data.model.repository.creditrequest;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import com.it4all.credit.admon.data.model.CreditRequest;

public interface CreditRequestRepository extends JpaRepository<CreditRequest, Long>, JpaSpecificationExecutor<CreditRequest> {

	@Query("SELECT a FROM CreditRequest a ")
	List<CreditRequest> getByPage(Pageable pageable);

}
