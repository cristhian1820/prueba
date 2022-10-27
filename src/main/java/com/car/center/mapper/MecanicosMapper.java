package com.car.center.mapper;

import com.car.center.response.MecanicosResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.car.center.dto.MecanicosDTO;
import com.car.center.request.MecanicosRequest;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MecanicosMapper {

    MecanicosMapper INSTANCE = Mappers.getMapper(MecanicosMapper.class);

    MecanicosDTO mecanicosRequestToMecaniosDTO(MecanicosRequest mecanicosRequest);

    List<MecanicosResponse> mecanicosDTOToMecanicosResponse(List<MecanicosDTO> mecanicosDTO);
}
