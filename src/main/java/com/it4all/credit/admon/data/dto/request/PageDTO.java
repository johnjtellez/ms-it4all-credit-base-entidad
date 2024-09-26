package com.it4all.credit.admon.data.dto.request;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * number of page
	 */
	Integer numberPage;
	
	/**
	 * count of register by page
	 */
	Integer registerByPage;
	
	/**
	 * Field Name by Order
	 */
	String orderBy;
	
	/**
	 * Order is Ascending
	 */
	Boolean ordenAscending;

}
