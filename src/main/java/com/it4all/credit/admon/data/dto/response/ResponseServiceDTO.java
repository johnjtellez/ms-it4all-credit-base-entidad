package com.it4all.credit.admon.data.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseServiceDTO implements Serializable{/**
	 *
	 */
	private static final long serialVersionUID = 8537179071289020789L;

	/**
	 * Objeto de datos generado por cada metodo implementado por los Microservicios
	 */
	private Object object;

	/**
	 * Define el exito o no de un llamda a un Metodo del Microservicio
	 */
	private Boolean success;

	/**
	 * Codigo asignado a la respuesta si es exitoso siempre llevara 1 en caso
	 * contrario el definido
	 */
	private String codeResponse;

	/**
	 * Descripción asociada a cada respuesta
	 */
	private String descriptionResponse;

	/**
	 * Descripción generada por la excepcion
	 */
	private String descriptionException;

	/**
	 * Variable utilizada para referrirnos a la cantidad de registros entregados es
	 * util en el momento de una consulta de datos.
	 */
	private Long countTotal;
	
}
