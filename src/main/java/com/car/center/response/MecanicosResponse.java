package com.car.center.response;

import lombok.Data;

@Data
public class MecanicosResponse {

	private Long id;

	private Integer tipoDocumento;

	private Long documento;

	private String primerNombre;

	private String segundoNombre;

	private String primerApellido;

	private String segundoApellido;

	private String celular;

	private String direccion;

	private String email;

	private String estado;
}
