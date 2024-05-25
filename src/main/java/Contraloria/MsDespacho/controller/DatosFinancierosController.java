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
import Contraloria.MsDespacho.dto.DatosFinancieros.CreateDatosFinancierosRequest;
import Contraloria.MsDespacho.dto.DatosFinancieros.DatosFinancierosDto;
import Contraloria.MsDespacho.dto.DatosFinancieros.UpdateDatosFinancierosRequest;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.DatosFinancierosMapper;
import Contraloria.MsDespacho.model.DatosFinancieros;
import Contraloria.MsDespacho.model.Proveedor;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CatalogoService;
import Contraloria.MsDespacho.service.DatosFinancierosService;
import Contraloria.MsDespacho.service.ProveedorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DATOSFINANCIEROS)
@Tag(name = "DatosFinancieros")
public class DatosFinancierosController {
    @Autowired
    DatosFinancierosService datosFinancierosService;

    @Autowired
    ProveedorService proveedorService;

    @Autowired
    DatosFinancierosMapper datosFinancierosMapper;

    @Autowired
    CatalogoService catalogoService;

    @GetMapping(ApiRoutes.LISTAR_DATOSFINANCIEROS)
    public ResponseEntity<ApiResponse<?>> getDatosFinancieros() {
        try {
            List<DatosFinancieros> datosFinancieross = datosFinancierosService.findAll();
            List<DatosFinancierosDto> datosFinancierosDtos = datosFinancieross.stream()
                    .map(datosFinancierosMapper::toDto)
                    .collect(Collectors.toList());

            for(DatosFinancierosDto datosFinancierosDto : datosFinancierosDtos){

                int tipoContrato = datosFinancierosDto.getTipoContrato();

                if(tipoContrato>0)
                datosFinancierosDto.setTipoContratoDescripcion(catalogoService.findById(tipoContrato).getDescripcion());

                int tipoServicio = datosFinancierosDto.getTipoServicio();

                if(tipoServicio>0)
                datosFinancierosDto.setTipoServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());

                
            }
         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", datosFinancierosDtos, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }


    @GetMapping(ApiRoutes.BUSCAR_DATOSFINANCIEROS_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        
        DatosFinancieros datosFinancieros = datosFinancierosService.findById(id);

        DatosFinancierosDto datosFinancierosDto = datosFinancierosMapper.toDto(datosFinancieros);

        int tipoContrato = datosFinancierosDto.getTipoContrato();

        datosFinancierosDto.setTipoContratoDescripcion(catalogoService.findById(tipoContrato).getDescripcion());

        int tipoServicio = datosFinancierosDto.getTipoServicio();

        datosFinancierosDto.setTipoServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", datosFinancierosDto, Collections.emptyList()));
        
    }

    @PostMapping(ApiRoutes.CREAR_DATOSFINANCIEROS)
    public ResponseEntity<ApiResponse<?>> create(@Valid @RequestBody CreateDatosFinancierosRequest request) throws NotFoundException {
            Proveedor proveedorEncontrado = proveedorService.findById(request.getIdProveedor());

            request.setProveedor(proveedorEncontrado);

            DatosFinancieros datosFinancieros = datosFinancierosMapper.createRequestToEntity(request);

            datosFinancierosService.add(datosFinancieros);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_DATOSFINANCIEROS)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateDatosFinancierosRequest request)  throws NotFoundException{
        
        Integer idDatosFinanciero = request.getId();

        DatosFinancieros datosFinancieros = datosFinancierosService.findById(idDatosFinanciero);
        
        datosFinancierosMapper.updateRequestToEntity(datosFinancieros, request);

        datosFinancierosService.update(datosFinancieros);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_DATOSFINANCIEROS)
    public ResponseEntity<ApiResponse<?>> deleteUsuario(@PathVariable int id)  throws NotFoundException{
        
            DatosFinancieros datosFinancieros = datosFinancierosService.findById(id);
                    
            datosFinancierosService.delete(datosFinancieros,1);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }
}
