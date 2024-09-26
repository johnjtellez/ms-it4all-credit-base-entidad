package com.it4all.credit.admon.data.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it4all.credit.admon.data.model.TaskProgress;

public interface TaskProgressRepository extends JpaRepository<TaskProgress, Long>, JpaSpecificationExecutor<TaskProgress> {

	TaskProgress findByTaskId(String taskId);

	@Query("SELECT a FROM TaskProgress a")
	List<TaskProgress> getByPage(
			Pageable pageable);

	@Query("SELECT a FROM TaskProgress a "
			+ "WHERE (a.taskId = :taskId "
			+ "OR :taskId = null "
			+ "OR :taskId = '') "
			+ "AND a.progress <= :progress")
	List<TaskProgress> getByActive(
			Pageable pageable,
			@Param("taskId") String taskId,
			@Param("progress") Integer progress);
}
