package com.it4all.credit.admon.data.dto.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRulesDTO implements Serializable{
	/**
	 * BusinessRulesDTO
	 */
	private static final long serialVersionUID = -7705353163969374917L;

	private Long id;

	private String  name;

	private String  code;

	private String  nameField;

	private Boolean  isEnabled;

	private String  description;

	private String  messageError;

	private String  query;
}
