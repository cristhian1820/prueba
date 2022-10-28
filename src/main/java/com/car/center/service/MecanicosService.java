package com.car.center.service;

import java.util.List;

import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;

public interface MecanicosService {

	ProcesoResponse guardar(MecanicosRequest mecanicosRequest);
	
	ProcesoResponse actualizar(MecanicosRequest mecanicosRequest) ;
	
	ProcesoResponse eliminar(Long mecanicosId) ;
	
	List<MecanicosResponse> consultar();

	List<MecanicosResponse> consultarPorEstado(String estado) ;
}
