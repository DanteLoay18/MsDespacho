package Contraloria.MsDespacho.controller;

import java.util.Collections;
import java.util.List;
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

import Contraloria.MsDespacho.constants.MensajesParametrizados;
import Contraloria.MsDespacho.dto.ApiResponse;
import Contraloria.MsDespacho.dto.Cargo.CargoDto;
import Contraloria.MsDespacho.dto.Cargo.CreateCargoRequest;
import Contraloria.MsDespacho.dto.Cargo.UpdateCargoRequest;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.CargoMapper;
import Contraloria.MsDespacho.model.Cargo;
import Contraloria.MsDespacho.model.Documento;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CargoService;
import Contraloria.MsDespacho.service.DocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_CARGO)
@Tag(name = "Cargo")
public class CargoController {

    @Autowired
    CargoService cargoService;

    @Autowired
    DocumentoService documentoService;

    @Autowired
    CargoMapper cargoMapper;
    

    @GetMapping(ApiRoutes.LISTAR_CARGOS)
    public ResponseEntity<ApiResponse<?>> findAll() {
        try {
            List<Cargo> cargos = cargoService.findAll();

            System.out.println(cargos);
            List<CargoDto> cargosDto = cargos.stream()
                    .map(cargoMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", cargosDto, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @GetMapping(ApiRoutes.BUSCAR_DOCUMENTO_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        
        Cargo cargo = cargoService.findById(id);

        CargoDto cargoDto = cargoMapper.toDto(cargo);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", cargoDto, Collections.emptyList()));
        
    }

    @GetMapping(ApiRoutes.BUSCAR_DOCUMENTO_POR_CODIGOBARRA)
    public ResponseEntity<ApiResponse<?>> buscarPorCodigoDeBarra(@RequestParam String codigoBarra) throws NotFoundException{
        
        Cargo cargo = cargoService.findByCodigoBarra(codigoBarra);

        CargoDto cargoDto = cargoMapper.toDto(cargo);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", cargoDto, Collections.emptyList()));
        
    }

    @GetMapping(ApiRoutes.LISTAR_CARGOS_PAGINADO)
    public ResponseEntity<ApiResponse<?>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int rows ){
        
        
        PageRequest pageRequest = PageRequest.of(page, rows);

        Page<Cargo> cargos = cargoService.findAll(pageRequest);

        PaginatorResponse<CargoDto> cargosDto = cargoMapper.toPaginationDto(cargos);


        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", cargosDto, Collections.emptyList()));
        
    }


    @PostMapping(ApiRoutes.CREAR_CARGO)
    public ResponseEntity<ApiResponse<?>> crearCargo(@Valid @RequestBody CreateCargoRequest request) throws NotFoundException {
            
            Documento documento = documentoService.findById(request.getIdDocumento());

            request.setDocumento(documento);

            Cargo cargo = cargoMapper.createRequestToEntity(request);

            cargoService.add(cargo);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }   

    @PutMapping(ApiRoutes.ACTUALIZAR_CARGO)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateCargoRequest request)  throws NotFoundException{
        
        Cargo cargo = cargoService.findById(request.getId());

        if(cargo.getDocumento().getId() != request.getIdDocumento()){
            Documento documento = documentoService.findById(request.getIdDocumento());

            request.setDocumento(documento);
        }

        cargo = cargoMapper.updateRequestToEntity(request);

        cargoService.update(cargo);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, cargo, Collections.emptyList() ));
        
    }


    @DeleteMapping(ApiRoutes.ENDPOINT_CARGO)
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id)  throws NotFoundException{
        
            Cargo cargo = cargoService.findById(id);
                    
            cargoService.delete(cargo);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }



}
