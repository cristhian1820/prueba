package com.car.center.controller;

import com.car.center.exception.InvalidDataException;
import com.car.center.request.MecanicosRequest;
import com.car.center.response.MecanicosResponse;
import com.car.center.response.ProcesoResponse;
import com.car.center.service.MecanicosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "MecanicosController")
@Log4j2
@RestController
@RequestMapping("/mecanicos")
public class MecanicosController {

    @Autowired
    private MecanicosService mecanicosService;

    @ApiOperation(value = "guardar", notes = "Metodo encargado de guardar la informacion de " +
            "los mecanicos", nickname = "guardar")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = ProcesoResponse.class),
            @ApiResponse(code = 500, message = "USRMSG-Se presento un problema, reporte e intente luego"),
            @ApiResponse(code = 400, message = "USRMSG-El tipo de documento es obligatorio ")})
    @PostMapping(value = "/guardar")
    public ResponseEntity<ProcesoResponse> guarar(@Valid @RequestBody MecanicosRequest mecanicosRequest, BindingResult result) {
        log.debug("Creando mecanico con data {}", mecanicosRequest);
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return ResponseEntity.ok().body(mecanicosService.guardar(mecanicosRequest));
    }

    @ApiOperation(value = "actualizar", notes = "Metodo encargado de actualizar la informacion de " +
            "los mecanicos", nickname = "actualizar")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = ProcesoResponse.class),
            @ApiResponse(code = 500, message = "USRMSG-Se presento un problema, reporte e intente luego"),
            @ApiResponse(code = 400, message = "USRMSG-No existe Mecanico con el id: ")})
    @PostMapping(value = "/actualizar")
    public ResponseEntity<ProcesoResponse> actualizar(@RequestBody MecanicosRequest mecanicosRequest) {
        return ResponseEntity.ok().body(mecanicosService.actualizar(mecanicosRequest));
    }

    @ApiOperation(value = "eliminar", notes = "Metodo encargado de eliminar la informacion de " +
            "los mecanicos", nickname = "eliminar")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = ProcesoResponse.class),
            @ApiResponse(code = 500, message = "USRMSG-Se presento un problema, reporte e intente luego"),
            @ApiResponse(code = 400, message = "USRMSG-No existe Mecanico con el id: ")})
    @PostMapping(value = "/eliminar")
    public ResponseEntity<ProcesoResponse> eliminar(@RequestParam Long mecanicosId) throws Exception {
        return ResponseEntity.ok().body(mecanicosService.eliminar(mecanicosId));
    }

    @ApiOperation(value = "consultar", notes = "Metodo encargado de consultar la informacion de " +
            "los mecanicos", nickname = "consultar")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = ProcesoResponse.class),
            @ApiResponse(code = 500, message = "USRMSG-Se presento un problema, reporte e intente luego"),
            @ApiResponse(code = 400, message = "USRMSG-No existen mecanicos ")})
    @GetMapping(value = "/consultar")
    public ResponseEntity<List<MecanicosResponse>> consultar() {
        return ResponseEntity.ok().body(mecanicosService.consultar());
    }

    @ApiOperation(value = "consultar-por-estado", notes = "Metodo encargado de consultar el estado de " +
            "los mecanicos", nickname = "consultarPorEstado")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = ProcesoResponse.class),
            @ApiResponse(code = 500, message = "USRMSG-Se presento un problema, reporte e intente luego"),
            @ApiResponse(code = 400, message = "USRMSG-No existe Mecanico con el estado: ")})
    @GetMapping(value = "/consultar-por-estado")
    public ResponseEntity<List<MecanicosResponse>> consultarPorEstado(@RequestParam String estado) throws Exception{
        return ResponseEntity.ok().body(mecanicosService.consultarPorEstado(estado));
    }

}
