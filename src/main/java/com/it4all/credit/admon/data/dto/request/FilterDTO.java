package com.it4all.credit.admon.data.dto.request;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * field
	 */
    private String field;

	/**
	 * type operator
	 * See class SearchFilter
	 */
    private String operator;

    /**
	 * value
	 */
    private List<ValueDTO> values;

}
