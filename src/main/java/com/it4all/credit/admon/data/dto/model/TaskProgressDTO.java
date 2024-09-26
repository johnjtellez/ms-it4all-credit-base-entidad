package com.it4all.credit.admon.data.dto.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskProgressDTO implements Serializable{
	/**
	 * TaskProgressDTO
	 */
	private static final long serialVersionUID = -7705353163969374917L;

	private Long id;

    private String taskId;

    private int progress;
}
