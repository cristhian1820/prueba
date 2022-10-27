package com.car.center.controller;

import com.car.center.request.MecanicosRequest;
import com.car.center.response.ProcesoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping(value= "/cargar")
    public ResponseEntity<String> actualizar() throws Exception {
        return ResponseEntity.ok().body("mecanicosService.actualizar(mecanicosRequest)");
    }
}
