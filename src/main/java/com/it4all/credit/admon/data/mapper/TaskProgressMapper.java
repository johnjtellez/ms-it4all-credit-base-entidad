package com.it4all.credit.admon.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.it4all.credit.admon.data.dto.model.TaskProgressDTO;
import com.it4all.credit.admon.data.model.TaskProgress;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskProgressMapper extends GenericMapper<TaskProgressDTO, TaskProgress>{

	TaskProgressDTO toDto(TaskProgress taskProgress);

	TaskProgress toEntity(TaskProgressDTO taskProgressDTO);
}
