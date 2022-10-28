package com.car.center.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.car.center.dto.MecanicosDTO;
import com.car.center.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.center.mapper.MecanicosMapper;
import com.car.center.repository.MecanicosRepository;
import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;

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
        response.setMsj("Se guardo con exito");
        return response;
    }

    @Override
    public ProcesoResponse actualizar(MecanicosRequest mecanicosRequest) {

        ProcesoResponse response = new ProcesoResponse();
        Optional<MecanicosDTO> mecanicoId = mecanicosRepository.findById(mecanicosRequest.getId());
        if (mecanicoId.isPresent()) {
            mecanicosRepository.save(mecanicosMapper.mecanicosRequestToMecaniosDTO(mecanicosRequest));
            response.setEstado(true);
            response.setMsj("Se actualizo la informacion");
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
            response.setMsj("Se elimino el mecanico");
        } else {
            throw new NoSuchElementException("No existe Mecanico con el id: " + mecanicosId);
        }
        return response;
    }

    @Override
    public List<MecanicosResponse> consultar() {
        List<MecanicosDTO> response = mecanicosRepository.findAll();
        return mecanicosMapper.mecanicosDTOToMecanicosResponse(response);
    }

    @Override
    public List<MecanicosResponse> consultarPorEstado(String estado) {
        List<MecanicosDTO> response = mecanicosRepository.findAllByEstado(estado);
        return mecanicosMapper.mecanicosDTOToMecanicosResponse(response);
    }
}
