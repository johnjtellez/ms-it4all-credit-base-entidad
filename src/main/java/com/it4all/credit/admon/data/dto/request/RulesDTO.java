package com.it4all.credit.admon.data.dto.request;

import java.io.Serializable;
import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RulesDTO implements Serializable {
	/**
	 * RulesDTO
	 */
	private static final long serialVersionUID = -3173197016978550293L;
	
	String code;
	
	String fieldName;
	
	LinkedHashMap<String, Object> objetoField;

	LinkedHashMap<String, Object> objetoForm;

}
