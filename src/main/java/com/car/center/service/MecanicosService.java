package com.car.center.service;

import java.util.List;

import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;

public interface MecanicosService {

	ProcesoResponse guardar(MecanicosRequest mecanicosRequest) throws Exception;
	
	ProcesoResponse actualizar(MecanicosRequest mecanicosRequest) throws Exception;
	
	ProcesoResponse eliminar(Long mecanicosId) throws Exception;
	
	List<MecanicosResponse> consultar() throws Exception;

	List<MecanicosResponse> consultarPorEstado(String estado) throws Exception;
}
