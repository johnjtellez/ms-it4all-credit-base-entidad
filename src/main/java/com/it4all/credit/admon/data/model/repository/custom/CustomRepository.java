package com.it4all.credit.admon.data.model.repository.custom;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import com.it4all.credit.admon.data.model.Custom;

public interface CustomRepository extends JpaRepository<Custom, Long>, JpaSpecificationExecutor<Custom> {

	@Query("SELECT a FROM Custom a ")
	List<Custom> getByPage(Pageable pageable);

}
