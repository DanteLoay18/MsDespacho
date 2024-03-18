package Contraloria.MsDespacho.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
import Contraloria.MsDespacho.dto.Documento.CreateDocumentoRequest;
import Contraloria.MsDespacho.dto.Documento.DocumentoDto;
import Contraloria.MsDespacho.dto.Enumerado.CreateEnumeradoRequest;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.DocumentoMapper;
import Contraloria.MsDespacho.model.Documento;
import Contraloria.MsDespacho.model.Enumerado;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.DocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DOCUMENTO)
@Tag(name = "Documento")
public class DocumentoController {

    @Autowired
    DocumentoService documentoService;

    @Autowired
    DocumentoMapper documentoMapper;
    

    @GetMapping(ApiRoutes.LISTAR_DOCUMENTOS)
    public ResponseEntity<ApiResponse<?>> findAll() {
        try {
            List<Documento> documentos = documentoService.findAll();

            List<DocumentoDto> documentosDto = documentos.stream()
                    .map(documentoMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", documentosDto, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }


    @GetMapping(ApiRoutes.LISTAR_DOCUMENTOS_PAGINADO)
    public ResponseEntity<ApiResponse<?>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int rows ){
        
        
        PageRequest pageRequest = PageRequest.of(page, rows);

        Page<Documento> documentos = documentoService.findAll(pageRequest);

        PaginatorResponse<DocumentoDto> documentosDto = documentoMapper.toPaginationDto(documentos);


        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", documentosDto, Collections.emptyList()));
        
    }

    @PostMapping("crear")
    public ResponseEntity<ApiResponse<?>> crearDocumento(@Valid @RequestBody CreateDocumentoRequest request)  {

            
            Documento documento = documentoMapper.createRequestToEntity(request);

            documentoService.add(documento);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }
}
