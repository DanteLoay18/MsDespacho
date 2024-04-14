package Contraloria.MsDespacho.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import Contraloria.MsDespacho.constants.MensajesParametrizados;
import Contraloria.MsDespacho.dto.ApiResponse;
import Contraloria.MsDespacho.dto.CargoDevolucion.CargoDevolucionDto;
import Contraloria.MsDespacho.dto.CargoDevolucion.CreateCargoDevolucion;
import Contraloria.MsDespacho.dto.CargoDevolucion.UpdateCargoDevolucion;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.CargoDevolucionMapper;
import Contraloria.MsDespacho.model.CargoDevolucion;
import Contraloria.MsDespacho.model.CargoDistribucion;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CargoDevolucionService;
import Contraloria.MsDespacho.service.CargoDistribucionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_CARGODEVOLUCION)
@Tag(name = "Cargo Devolucion")
public class CargoDevolucionController {
    
    @Autowired
    CargoDevolucionService cargoDevolucionService;

    @Autowired
    CargoDistribucionService cargoDistribucionService;

    @Autowired
    CargoDevolucionMapper cargoDevolucionMapper;

    @GetMapping(ApiRoutes.LISTAR_CARGOSDEVOLUCION)
    public ResponseEntity<ApiResponse<?>> findAll() {
        try {
            List<CargoDevolucion> cargosDevoluciones = cargoDevolucionService.findAll();

            List<CargoDevolucionDto> devolucionDtos = cargosDevoluciones.stream()
                    .map(cargoDevolucionMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", devolucionDtos, Collections.emptyList()));
        } catch (Exception ex) {
            System.out.println(ex);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @GetMapping(ApiRoutes.LISTAR_CARGOSDEVOLUCION_PAGINADO)
    public ResponseEntity<ApiResponse<?>> findAllPaginated(@RequestParam(defaultValue = "0") int page, 
                                                           @RequestParam(defaultValue = "10") int rows ){
        
        
        PageRequest pageRequest = PageRequest.of(page, rows);

        Page<CargoDevolucion> cargoDevoluciones = cargoDevolucionService.findAll( pageRequest);

        PaginatorResponse<CargoDevolucionDto> cargosDevolucionesDto = cargoDevolucionMapper.toPaginationDto(cargoDevoluciones);


        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", cargosDevolucionesDto, Collections.emptyList()));
        
    }

    @GetMapping(ApiRoutes.BUSCAR_CARGOSDEVOLUCION_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        
        CargoDevolucion cargoDevolucion = cargoDevolucionService.findById(id);

        CargoDevolucionDto cargoDevolucionDto = cargoDevolucionMapper.toDto(cargoDevolucion);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", cargoDevolucionDto, Collections.emptyList()));
        
    }

    @PostMapping(ApiRoutes.CREAR_CARGODISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> crearCargoDistribucion(@RequestBody CreateCargoDevolucion request) throws NotFoundException {
            
            CargoDistribucion cargoDistribucion = cargoDistribucionService.findById(request.getIdCargoDistribucion());

            request.setCargoDistribucion(cargoDistribucion);

            CargoDevolucion cargoDevolucion = cargoDevolucionMapper.createRequestToEntity(request);

            cargoDevolucionService.add(cargoDevolucion);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }   

    @PutMapping(ApiRoutes.ACTUALIZAR_CARGODISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateCargoDevolucion request)  throws NotFoundException{
        
        CargoDevolucion cargoDevolucion = cargoDevolucionService.findById(request.getId());

        if(cargoDevolucion.getCargoDistribucion().getId() != request.getIdCargoDistribucion()){

            CargoDistribucion cargoDistribucion = cargoDistribucionService.findById(request.getIdCargoDistribucion());

            request.setCargoDistribucion(cargoDistribucion);
        }

        cargoDevolucionMapper.updateRequestToEntity(cargoDevolucion,request);

        cargoDevolucionService.update(cargoDevolucion);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }


    @DeleteMapping(ApiRoutes.ELIMINAR_CARGODISTRIBUCION)
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id)  throws NotFoundException{
        
            CargoDevolucion cargoDevolucion = cargoDevolucionService.findById(id);
                    
            cargoDevolucionService.delete(cargoDevolucion);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }

    
}
