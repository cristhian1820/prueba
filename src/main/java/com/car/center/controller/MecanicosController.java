package com.car.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;
import com.car.center.service.MecanicosService;

import javax.validation.Valid;


@RestController
@RequestMapping("/mecanicos")
public class MecanicosController {
	
	@Autowired
	private MecanicosService mecanicosService;
	
	@PostMapping(value = "/guardar")
	public ResponseEntity<ProcesoResponse> guarar(@RequestBody MecanicosRequest mecanicosRequest) throws Exception {
		return ResponseEntity.ok().body(mecanicosService.guardar(mecanicosRequest));
	}

	@PostMapping(value = "/actualizar")
	public ResponseEntity<ProcesoResponse> actualizar(@RequestBody MecanicosRequest mecanicosRequest) throws Exception {
		return ResponseEntity.ok().body(mecanicosService.actualizar(mecanicosRequest));
	}

	@PostMapping(value = "/eliminar")
	public ResponseEntity<ProcesoResponse> eliminar(@RequestParam Long mecanicosId) throws Exception {
		return ResponseEntity.ok().body(mecanicosService.eliminar(mecanicosId));
	}

	@GetMapping(value = "/consultar")
	public ResponseEntity<List<MecanicosResponse>> consultar() throws Exception {
		return ResponseEntity.ok().body(mecanicosService.consultar());
	}

	@GetMapping(value = "/consultar-por-estado")
	public ResponseEntity<List<MecanicosResponse>> consultarPorEstado(@RequestParam String estado) throws Exception {
		return ResponseEntity.ok().body(mecanicosService.consultarPorEstado(estado));
	}

}
