package com.it4all.credit.admon.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.it4all.credit.admon.data.dto.model.CreditRequestDTO;
import com.it4all.credit.admon.data.model.CreditRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditRequestMapper extends GenericMapper<CreditRequestDTO, CreditRequest>{

}
