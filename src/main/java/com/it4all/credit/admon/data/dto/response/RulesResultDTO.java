package com.it4all.credit.admon.data.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RulesResultDTO implements Serializable{/**
	 *
	 */
	private static final long serialVersionUID = 8537179071289020789L;

	/**
	 */
	String ruleName;

	/**
	 * Define el exito o no de un llamda a un Metodo del Microservicio
	 */
	Boolean result;

	/**
	 * Codigo asignado a la respuesta si es exitoso siempre llevara 1 en caso
	 * contrario el definido
	 */
	String messageError;

}
