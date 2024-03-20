package Contraloria.MsDespacho.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Contraloria.MsDespacho.constants.MensajesParametrizados;
import Contraloria.MsDespacho.dto.ApiResponse;
import Contraloria.MsDespacho.dto.Distribucion.CargoDistribucionDto;
import Contraloria.MsDespacho.dto.Distribucion.CreateDistribucionRequest;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.DistribucionMapper;
import Contraloria.MsDespacho.model.Cargo;
import Contraloria.MsDespacho.model.CargoAdicional;
import Contraloria.MsDespacho.model.CargoDistribucion;
import Contraloria.MsDespacho.model.DetalleCargoDistribucion;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CargoAdicionalService;
import Contraloria.MsDespacho.service.CargoDistribucionService;
import Contraloria.MsDespacho.service.CargoService;
import Contraloria.MsDespacho.service.DetalleCargoDistribucionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DISTRIBUCION)
@Tag(name = "Distribucion")
public class DistribucionController {

    @Autowired
    CargoService cargoService;

    @Autowired
    CargoAdicionalService cargoAdicionalService;

    @Autowired
    CargoDistribucionService cargoDistribucionService;

    @Autowired
    DetalleCargoDistribucionService detalleCargoDistribucionService;

    @Autowired
    DistribucionMapper distribucionMapper;

    @PostMapping(ApiRoutes.CREAR_DISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> crearDistribucion(@Valid @RequestBody CreateDistribucionRequest request) throws NotFoundException{
            
            CargoDistribucion cargoDistribucion = distribucionMapper.createRequestToDistribucionEntity(request);

            CargoDistribucion cargoDistribucionCreado = cargoDistribucionService.add(cargoDistribucion);

            for (int cargoId : request.getCargos()) {
                
                Cargo cargoEncontrado = cargoService.findById(cargoId);

                DetalleCargoDistribucion detalleCargoDistribucion = distribucionMapper.createRequestToDetalleCargoDistribucionEntity(cargoEncontrado, cargoDistribucionCreado);
                
                detalleCargoDistribucionService.add(detalleCargoDistribucion);

            }
            
            if (request.getCargosAdicionales() != null && !request.getCargosAdicionales().isEmpty()) {
                for (String numeroDocumentoAdicional : request.getCargosAdicionales()) {
                    CargoAdicional cargoAdicional = distribucionMapper.createRequestToCargoAdicionalEntity(numeroDocumentoAdicional, cargoDistribucionCreado);
                    cargoAdicionalService.add(cargoAdicional);
                }
            }
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO,null ,Collections.emptyList()));
        
    }   

    @GetMapping(ApiRoutes.LISTAR_DISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> findAll(@RequestParam(required = false) Optional<Integer> numeroCargo,
                                                  @RequestParam(required = false) Optional<Integer> idSedeDestino) {
        try {
            List<CargoDistribucion> cargoDistribucions = cargoDistribucionService.findAllConParametros(idSedeDestino,numeroCargo);

            // List<CargoDto> cargosDto = cargoDistribucions.stream()
            //         .map(cargoMapper::toDto)
            //         .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", cargoDistribucions, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @GetMapping(ApiRoutes.LISTAR_DISTRIBUCION_PAGINADO)
    public ResponseEntity<ApiResponse<?>> findAllPaginado(@RequestParam(required = false) Optional<Integer> numeroCargo,
                                                          @RequestParam(required = false) Optional<Integer> idSedeDestino,
                                                          @RequestParam(defaultValue = "0") int page, 
                                                          @RequestParam(defaultValue = "10") int rows ) {
        try {
            PageRequest pageRequest = PageRequest.of(page, rows);

            Page<CargoDistribucion> cargoDistribucions = cargoDistribucionService.findAllConParametrosPaginado(idSedeDestino,numeroCargo,pageRequest);

            PaginatorResponse<CargoDistribucionDto> cargosDto = distribucionMapper.toPaginationDto(cargoDistribucions);
        
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", cargosDto, Collections.emptyList()));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }





    
}
