package com.car.center.service;

import java.util.List;
import java.util.Optional;

import com.car.center.dto.MecanicosDTO;
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
    public ProcesoResponse guardar(MecanicosRequest mecanicosRequest) throws Exception {
        try {
            MecanicosDTO a = mecanicosRepository.save(mecanicosMapper.mecanicosRequestToMecaniosDTO(mecanicosRequest));
            ProcesoResponse b = new ProcesoResponse();
            if (a != null) {
                b.setEstado(true);
                b.setMsj("Se guardo con exito");
            } else {
                b.setEstado(false);
                b.setMsj("No se guardo");
            }
            return b;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProcesoResponse actualizar(MecanicosRequest mecanicosRequest) throws Exception {
        try {
            ProcesoResponse response = new ProcesoResponse();
            Object existeMecanico = mecanicosRepository.findById(mecanicosRequest.getId());
            if (existeMecanico != null) {
                MecanicosDTO mecanicoActualizado = mecanicosRepository.save(mecanicosMapper.mecanicosRequestToMecaniosDTO(mecanicosRequest));
                response.setEstado(true);
                response.setMsj("Se actualizo la informacion");
            } else {
                throw new Exception("El id del mecanico no existe");
            }
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProcesoResponse eliminar(Long mecanicosId) throws Exception {
        try {
            ProcesoResponse response = new ProcesoResponse();
            mecanicosRepository.deleteById(mecanicosId);
            response.setEstado(true);
            response.setMsj("Se elimino el mecanico");
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<MecanicosResponse> consultar() throws Exception {
        try {
            List<MecanicosDTO> response = mecanicosRepository.findAll();
            return mecanicosMapper.mecanicosDTOToMecanicosResponse(response);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<MecanicosResponse> consultarPorEstado(String estado) throws Exception {
        try {
            List<MecanicosDTO> response = mecanicosRepository.findAllByEstado(estado);
            return mecanicosMapper.mecanicosDTOToMecanicosResponse(response);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
