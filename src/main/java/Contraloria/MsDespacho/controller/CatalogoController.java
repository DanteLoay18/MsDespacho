package Contraloria.MsDespacho.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Contraloria.MsDespacho.constants.MensajesParametrizados;
import Contraloria.MsDespacho.dto.ApiResponse;
import Contraloria.MsDespacho.dto.Catalogo.CreateCatalogoRequest;
import Contraloria.MsDespacho.dto.Catalogo.CatalogoDto;
import Contraloria.MsDespacho.dto.Catalogo.UpdateCatalogoRequest;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.CatalogoMapper;
import Contraloria.MsDespacho.model.Catalogo;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CatalogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
// import io.swagger.v3.oas.annotations.responses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_ENUMERADO)
@Tag(name = "Catalogo")
public class CatalogoController {

    @Autowired
    CatalogoService enumeradoService;

    @Autowired
    CatalogoMapper enumeradoMapper;

    @GetMapping(ApiRoutes.LISTAR_ENUMERADOS)
    public ResponseEntity<ApiResponse<?>> getCatalogos() {
        try {
            List<Catalogo> enumerados = enumeradoService.findAll();
            List<CatalogoDto> enumeradosDto = enumerados.stream()
                    .map(enumeradoMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", enumeradosDto, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @GetMapping(ApiRoutes.BUSCAR_ENUMERADO_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        
        Catalogo enumerado = enumeradoService.findById(id);

        CatalogoDto enumeradoDto = enumeradoMapper.toDto(enumerado);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", enumeradoDto, Collections.emptyList()));
        
    }

    @GetMapping(ApiRoutes.LISTAR_ENUMERADOS_POR_PADRE)
    public ResponseEntity<ApiResponse<?>> getCatalogosByPadre(@PathVariable int id) throws NotFoundException {
        
            List<Catalogo> enumerados = enumeradoService.findCatalogosHijos(id);

            List<CatalogoDto> enumeradosDto = enumerados.stream()
                                .map(enumeradoMapper::toDto)
                                .collect(Collectors.toList());

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", enumeradosDto, Collections.emptyList()));
       
        
    }

    @Operation(summary = "Crear un catalogo", description = "Este endpoint crea un nuevo catalogo")
    @PostMapping(ApiRoutes.CREAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> createCatalogo(@Valid @RequestBody CreateCatalogoRequest request) throws NotFoundException {

            if(request.getIdPadre() > 0){
                Catalogo enumeradoPadre = enumeradoService.findById(request.getIdPadre());

                request.setPadre(enumeradoPadre);
            }
            
            Catalogo enumerado = enumeradoMapper.createRequestToEntity(request);

            enumeradoService.add(enumerado);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateCatalogoRequest request) throws NotFoundException{
        
        Catalogo enumerado = enumeradoService.findById(request.getId());

        if(enumerado.getPadre() != request.getPadre()){
            Catalogo enumeradoPadre = enumeradoService.findById(request.getIdPadre());

            request.setPadre(enumeradoPadre);
        }

        enumeradoMapper.updateRequestToEntity(enumerado,request);

        enumeradoService.update(enumerado);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id)  throws NotFoundException{
        
            Catalogo enumerado = enumeradoService.findById(id);
                    
            enumeradoService.delete(enumerado,1);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }

}
