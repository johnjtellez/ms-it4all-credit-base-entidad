package com.it4all.credit.admon.data.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it4all.credit.admon.data.model.Auditory;

@Repository
public interface AuditoryRepository extends JpaRepository<Auditory, Long> {

	@Query("SELECT a FROM Auditory a")
	List<Auditory> getByPage(
			Pageable pageable);

}
