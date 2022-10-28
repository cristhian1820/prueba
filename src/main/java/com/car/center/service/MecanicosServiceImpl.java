package com.car.center.service;

import com.car.center.dto.MecanicosDTO;
import com.car.center.mapper.MecanicosMapper;
import com.car.center.repository.MecanicosRepository;
import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MecanicosServiceImpl implements MecanicosService {

    @Autowired
    private MecanicosRepository mecanicosRepository;

    @Autowired
    private MecanicosMapper mecanicosMapper;

    @Override
    public ProcesoResponse guardar(MecanicosRequest mecanicosRequest) {

        ProcesoResponse response = new ProcesoResponse();
        if (mecanicosRequest.getTipoDocumento() == null) {
            throw new NoSuchElementException("El tipo de documento es obligatorio");
        }
        mecanicosRepository.save(mecanicosMapper.mecanicosRequestToMecaniosDTO(mecanicosRequest));
        response.setEstado(true);
        response.setMensaje("Se guardo con exito");
        return response;
    }

    @Override
    public ProcesoResponse actualizar(MecanicosRequest mecanicosRequest) {

        ProcesoResponse response = new ProcesoResponse();
        Optional<MecanicosDTO> mecanicoId = mecanicosRepository.findById(mecanicosRequest.getId());
        if (mecanicoId.isPresent()) {
            mecanicosRepository.save(mecanicosMapper.mecanicosRequestToMecaniosDTO(mecanicosRequest));
            response.setEstado(true);
            response.setMensaje("Se actualizo la informacion");
        } else {
            throw new NoSuchElementException("No existe Mecanico con el id: " + mecanicosRequest.getId());
        }
        return response;
    }

    @Override
    public ProcesoResponse eliminar(Long mecanicosId) {

        ProcesoResponse response = new ProcesoResponse();
        Optional<MecanicosDTO> mecanico = mecanicosRepository.findById(mecanicosId);
        if (mecanico.isPresent()) {
            mecanicosRepository.deleteById(mecanicosId);
            response.setEstado(true);
            response.setMensaje("Se elimino el mecanico");
        } else {
            throw new NoSuchElementException("No existe Mecanico con el id: " + mecanicosId);
        }
        return response;
    }

    @Override
    public List<MecanicosResponse> consultar() {
        List<MecanicosDTO> response = mecanicosRepository.findAll();
        if (response.isEmpty()) {
            throw new NoSuchElementException("No existen mecanicos");
        }
        return mecanicosMapper.mecanicosDTOToMecanicosResponse(response);
    }

    @Override
    public List<MecanicosResponse> consultarPorEstado(String estado) {
        List<MecanicosDTO> responseEstado = mecanicosRepository.findAllByEstado(estado);
        if (responseEstado.isEmpty()) {
            throw new NoSuchElementException("No existe mecanico con el estado: " + estado);
        }
        return mecanicosMapper.mecanicosDTOToMecanicosResponse(responseEstado);
    }
}
