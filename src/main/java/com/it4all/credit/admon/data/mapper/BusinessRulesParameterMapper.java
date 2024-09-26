package com.it4all.credit.admon.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.it4all.credit.admon.data.dto.model.BusinessRulesParameterDTO;
import com.it4all.credit.admon.data.model.BusinessRulesParameter;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BusinessRulesParameterMapper extends GenericMapper<BusinessRulesParameterDTO, BusinessRulesParameter>{
}
