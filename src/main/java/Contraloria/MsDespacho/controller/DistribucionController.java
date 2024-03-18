package Contraloria.MsDespacho.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Contraloria.MsDespacho.constants.MensajesParametrizados;
import Contraloria.MsDespacho.dto.ApiResponse;
import Contraloria.MsDespacho.dto.Distribucion.CreateDistribucionRequest;
import Contraloria.MsDespacho.mapper.DistribucionMapper;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CargoAdicionalService;
import Contraloria.MsDespacho.service.CargoDistribucionService;
import Contraloria.MsDespacho.service.DetalleCargoDistribucionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DISTRIBUCION)
@Tag(name = "Distribucion")
public class DistribucionController {

    @Autowired
    CargoAdicionalService cargoAdicionalService;

    @Autowired
    CargoDistribucionService cargoDistribucionService;

    @Autowired
    DetalleCargoDistribucionService detalleCargoDistribucionService;

    @Autowired
    DistribucionMapper distribucionMapper;

    @PostMapping(ApiRoutes.CREAR_DISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> crearDistribucion(@Valid @RequestBody CreateDistribucionRequest request) {
            
            
            
            // Documento documento = documentoService.findById(request.getIdDocumento());

            // request.setDocumento(documento);

            // Cargo cargo = cargoMapper.createRequestToEntity(request);

            // cargoService.add(cargo);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }   

    
}
