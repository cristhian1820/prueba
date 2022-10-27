package com.car.center.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.car.center.dto.MecanicosDTO;

import java.util.List;

@Repository
public interface MecanicosRepository extends JpaRepository<MecanicosDTO, Long> {

    List<MecanicosDTO> findAllByEstado(String estado);

}
