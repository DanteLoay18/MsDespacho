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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_CATALAGOS)
@Tag(name = "Catalogo")
public class CatalogoController {

    @Autowired
    CatalogoService catalagoService;

    @Autowired
    CatalogoMapper catalagoMapper;

    @GetMapping(ApiRoutes.LISTAR_CATALAGOS)
    public ResponseEntity<ApiResponse<?>> getCatalogos() {
        try {
            List<Catalogo> catalogos = catalagoService.findAll();
            List<CatalogoDto> catalogosDto = catalogos.stream()
                    .map(catalagoMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", catalogosDto, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
    }

    @GetMapping(ApiRoutes.BUSCAR_CATALAGOS_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        try {
            Catalogo catalago = catalagoService.findById(id);

            CatalogoDto catalagoDto = catalagoMapper.toDto(catalago);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", catalagoDto, Collections.emptyList()));
            
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
        
    }

    @GetMapping(ApiRoutes.LISTAR_CATALAGOS_POR_PADRE)
    public ResponseEntity<ApiResponse<?>> getCatalogosByPadre(@PathVariable int id) throws NotFoundException {
        try {
            List<Catalogo> catalogos = catalagoService.findCatalogosHijos(id);

            List<CatalogoDto> catalogosDto = catalogos.stream()
                                .map(catalagoMapper::toDto)
                                .collect(Collectors.toList());

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", catalogosDto, Collections.emptyList()));
                    
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
        
    }

    @Operation(summary = "Crear un catalogo", description = "Este endpoint crea un nuevo catalogo")
    @PostMapping(ApiRoutes.CREAR_CATALAGOS)
    public ResponseEntity<ApiResponse<?>> createCatalogo(@Valid @RequestBody CreateCatalogoRequest request) throws NotFoundException {
        try {
            if(request.getIdPadre() > 0){
                Catalogo catalagoPadre = catalagoService.findById(request.getIdPadre());

                request.setPadre(catalagoPadre);
            }
            
            Catalogo catalago = catalagoMapper.createRequestToEntity(request);

            catalagoService.add(catalago);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_CATALAGOS)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateCatalogoRequest request) throws NotFoundException{
        try {

            Catalogo catalago = catalagoService.findById(request.getId());

            catalagoMapper.updateRequestToEntity(catalago,request);

            catalagoService.update(catalago);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_CATALAGOS)
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id)  throws NotFoundException{
        try {
            Catalogo catalago = catalagoService.findById(id);
                    
            catalagoService.delete(catalago,1);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), null,Collections.emptyList()));
        }
        
    }

}
