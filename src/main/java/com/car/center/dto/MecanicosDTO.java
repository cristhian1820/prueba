package com.car.center.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mecanicos")
public class MecanicosDTO  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_documento", nullable = false)
	@NotNull(message="El tipo de documento es obligatorio")
	private Integer tipoDocumento;

	@Column(nullable = false)
	@NotNull(message="El documento es obligatorio")
	private Long documento;
	
	@Column(name = "primer_nombre", nullable = false)
	@NotNull(message="El primer nombre es obligatorio")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@Column(name = "primer_apellido", nullable = false)
	@NotNull(message="El primer apellido es obligatorio")
	private String primerApellido;
	
	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@Column(nullable = false)
	@NotNull(message="El celular es obligatorio")
	private String celular;

	@Column(nullable = false)
	@NotNull(message="la direccion es obligatorio")
	private String direccion;

	@Column(nullable = false)
	@NotNull(message="El email es obligatorio")
	private String email;

	@Column(nullable = false)
	@NotNull(message="El estado es obligatorio")
	private String estado;
}
