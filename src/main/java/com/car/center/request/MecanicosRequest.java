package com.car.center.request;

import lombok.Data;

@Data
public class MecanicosRequest {

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
