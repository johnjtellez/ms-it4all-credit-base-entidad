package com.it4all.credit.admon.data.dto.request;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterPageDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    /**
	 * Filters
	 */
    private List<FilterDTO> filters;

    /**
	 * Pagination
	 */
    private PageDTO page;
}
