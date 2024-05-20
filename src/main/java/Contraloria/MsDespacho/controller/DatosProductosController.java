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
import Contraloria.MsDespacho.dto.DatosProductos.CreateDatosProductosRequest;
import Contraloria.MsDespacho.dto.DatosProductos.DatosProductosDto;
import Contraloria.MsDespacho.dto.DatosProductos.UpdateDatosProductosRequest;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.DatosProductosMapper;
import Contraloria.MsDespacho.model.DatosProductos;
import Contraloria.MsDespacho.model.Proveedor;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CatalogoService;
import Contraloria.MsDespacho.service.DatosProductosService;
import Contraloria.MsDespacho.service.ProveedorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DATOSPRODUCTOS)
@Tag(name = "DatosProductos")
public class DatosProductosController {
    @Autowired
    DatosProductosService datosProductosService;

    @Autowired
    ProveedorService proveedorService;

    @Autowired
    DatosProductosMapper datosProductosMapper;

    @Autowired
    CatalogoService catalogoService;

    @GetMapping(ApiRoutes.LISTAR_DATOSPRODUCTOS)
    public ResponseEntity<ApiResponse<?>> getDatosProductos() {
        try {
            List<DatosProductos> datosProductoss = datosProductosService.findAll();
            List<DatosProductosDto> datosProductosDtos = datosProductoss.stream()
                    .map(datosProductosMapper::toDto)
                    .collect(Collectors.toList());

            for(DatosProductosDto datosProductoDto : datosProductosDtos){

                int tipoServicio = datosProductoDto.getTipoServicio();

                if(tipoServicio>0)
                datosProductoDto.setTipoServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());

                int tipoAcceso = datosProductoDto.getTipoAcceso();

                if(tipoAcceso>0)
                    datosProductoDto.setTipoAccesoDescripcion(catalogoService.findById(tipoAcceso).getDescripcion());
                
                int tipoEntrega = datosProductoDto.getTipoEntrega();

                if(tipoEntrega>0)
                    datosProductoDto.setTipoEntregaDescripcion(catalogoService.findById(tipoEntrega).getDescripcion());
            }

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", datosProductosDtos, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }


    @GetMapping(ApiRoutes.BUSCAR_DATOSPRODUCTOS_POR_ID)
    public ResponseEntity<ApiResponse<?>> findDatosProductos(@PathVariable int id) throws NotFoundException{
        
        DatosProductos datosProductos = datosProductosService.findById(id);
        
        DatosProductosDto datosProductosDto = datosProductosMapper.toDto(datosProductos);
        
        int tipoServicio = datosProductosDto.getTipoServicio();

        datosProductosDto.setTipoServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());

        int tipoAcceso = datosProductosDto.getTipoAcceso();

        datosProductosDto.setTipoAccesoDescripcion(catalogoService.findById(tipoAcceso).getDescripcion());

        int tipoEntrega = datosProductosDto.getTipoEntrega();

        datosProductosDto.setTipoEntregaDescripcion(catalogoService.findById(tipoEntrega).getDescripcion());
        
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", datosProductosDto, Collections.emptyList()));
        
    }

    @PostMapping(ApiRoutes.CREAR_DATOSPRODUCTOS)
    public ResponseEntity<ApiResponse<?>> create(@Valid @RequestBody CreateDatosProductosRequest request) throws NotFoundException {
            Proveedor proveedorEncontrado = proveedorService.findById(request.getIdProveedor());

            request.setProveedor(proveedorEncontrado);

            DatosProductos datosProductos = datosProductosMapper.createRequestToEntity(request);

            datosProductosService.add(datosProductos);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_DATOSPRODUCTOS)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateDatosProductosRequest request)  throws NotFoundException{
        
        DatosProductos datosProductos = datosProductosService.findById(request.getId());
        
        datosProductosMapper.updateRequestToEntity(datosProductos, request);

        datosProductosService.update(datosProductos);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_DATOSPRODUCTOS)
    public ResponseEntity<ApiResponse<?>> deleteDatosProductos(@PathVariable int id)  throws NotFoundException{
        
            DatosProductos datosProductos = datosProductosService.findById(id);
                    
            datosProductosService.delete(datosProductos);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }
}
