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
import Contraloria.MsDespacho.dto.Enumerado.CreateEnumeradoRequest;
import Contraloria.MsDespacho.dto.Enumerado.EnumeradoDto;
import Contraloria.MsDespacho.dto.Enumerado.UpdateEnumeradoRequest;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.EnumeradoMapper;
import Contraloria.MsDespacho.model.Enumerado;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.EnumeradoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_ENUMERADO)
@Tag(name = "Enumerado")
public class EnumeradoController {

    @Autowired
    EnumeradoService enumeradoService;

    @Autowired
    EnumeradoMapper enumeradoMapper;

    @GetMapping(ApiRoutes.LISTAR_ENUMERADOS)
    public ResponseEntity<ApiResponse<?>> getEnumerados() {
        try {
            List<Enumerado> enumerados = enumeradoService.findAll();
            List<EnumeradoDto> enumeradosDto = enumerados.stream()
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
        
        Enumerado enumerado = enumeradoService.findById(id);

        EnumeradoDto enumeradoDto = enumeradoMapper.toDto(enumerado);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", enumeradoDto, Collections.emptyList()));
        
    }

    @GetMapping(ApiRoutes.LISTAR_ENUMERADOS_POR_PADRE)
    public ResponseEntity<ApiResponse<?>> getEnumeradosByPadre(@PathVariable int id) throws NotFoundException {
        
            List<Enumerado> enumerados = enumeradoService.findEnumeradosHijos(id);

            List<EnumeradoDto> enumeradosDto = enumerados.stream()
                                .map(enumeradoMapper::toDto)
                                .collect(Collectors.toList());

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", enumeradosDto, Collections.emptyList()));
       
        
    }

    @PostMapping(ApiRoutes.CREAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> createEnumerado(@Valid @RequestBody CreateEnumeradoRequest request) throws NotFoundException {

            if(request.getIdPadre() > 0){
                Enumerado enumeradoPadre = enumeradoService.findById(request.getIdPadre());

                request.setPadre(enumeradoPadre);
            }
            
            Enumerado enumerado = enumeradoMapper.createRequestToEntity(request);

            enumeradoService.add(enumerado);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateEnumeradoRequest request)  throws NotFoundException{
        
        Enumerado enumerado = enumeradoService.findById(request.getId());

        if(enumerado.getPadre() != request.getPadre()){
            Enumerado enumeradoPadre = enumeradoService.findById(request.getIdPadre());

            request.setPadre(enumeradoPadre);
        }

        enumerado = enumeradoMapper.updateRequestToEntity(request);

        enumeradoService.update(enumerado);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_ENUMERADO)
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id)  throws NotFoundException{
        
            Enumerado enumerado = enumeradoService.findById(id);
                    
            enumeradoService.delete(enumerado);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }

}
