package com.it4all.credit.admon.data.dto.request;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateReportDTO implements Serializable {
	/**
	 * GenerateReportDTO
	 */
	private static final long serialVersionUID = -3173197016978550293L;
	
	String typeData;
	
	String typeReport;
	
	String nameReportJrxml;
	
	Map<String, Object> parameters;

}
