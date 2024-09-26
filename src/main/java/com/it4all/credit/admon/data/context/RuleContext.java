package com.it4all.credit.admon.data.context;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleContext implements Serializable {
	/**
	 * RuleContext
	 */
	private static final long serialVersionUID = -7705353163969374917L;

	private String ruleToExecute;

}
