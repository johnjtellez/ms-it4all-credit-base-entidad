package com.it4all.credit.admon.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.it4all.credit.admon.data.dto.model.BusinessRulesDTO;
import com.it4all.credit.admon.data.model.BusinessRules;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BusinessRulesMapper extends GenericMapper<BusinessRulesDTO, BusinessRules>{

}
