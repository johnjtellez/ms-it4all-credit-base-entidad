package com.it4all.credit.admon.data.dto.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRulesParameterDTO implements Serializable{
	/**
	 * BusinessRulesParameterDTO
	 */
	private Long  id;

	private String  name;

	private Boolean  isValueInField;

	private Long  businessRulesId;

	private BusinessRulesDTO businessRulesIdDTO;
}
