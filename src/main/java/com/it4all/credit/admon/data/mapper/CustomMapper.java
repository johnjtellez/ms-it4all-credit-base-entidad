package com.it4all.credit.admon.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.it4all.credit.admon.data.dto.model.CustomDTO;
import com.it4all.credit.admon.data.model.Custom;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomMapper extends GenericMapper<CustomDTO, Custom>{

}
