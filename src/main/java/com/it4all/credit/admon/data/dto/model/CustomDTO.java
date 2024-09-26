package com.it4all.credit.admon.data.dto.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDTO implements Serializable{
	/**
	 * CustomDTO
	 */
	private static final long serialVersionUID = 1L;
	private Long  id;

	private String  name;


}