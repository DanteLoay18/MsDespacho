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
import Contraloria.MsDespacho.dto.Proveedor.CreateProveedorRequest;
import Contraloria.MsDespacho.dto.Proveedor.ProveedorDto;
import Contraloria.MsDespacho.dto.Proveedor.UpdateProveedorRequest;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.ProveedorMapper;
import Contraloria.MsDespacho.model.Proveedor;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CatalogoService;
import Contraloria.MsDespacho.service.ProveedorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_PROVEEDOR)
@Tag(name = "Proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @Autowired
    ProveedorMapper proveedorMapper;

    @Autowired
    CatalogoService catalogoService;

    @GetMapping(ApiRoutes.LISTAR_PROVEEDORS)
    public ResponseEntity<ApiResponse<?>> getProveedores() {
        try {
            List<Proveedor> proveedors = proveedorService.findAll();
            List<ProveedorDto> proveedorDtos = proveedors.stream()
                    .map(proveedorMapper::toDto)
                    .collect(Collectors.toList());

            

            for (ProveedorDto proveedorDto : proveedorDtos) {

                int tipoProv = proveedorDto.getTipoProveedor();
                
                if(tipoProv>0)
                proveedorDto.setTipoProveedorDescripcion(catalogoService.findById(tipoProv).getDescripcion());

                int tipoDocumento = proveedorDto.getTipoDocumento();

                if(tipoDocumento>0)
                proveedorDto.setTipoDocumentoDescripcion(catalogoService.findById(tipoDocumento).getDescripcion());
                
                int tipoServicio = proveedorDto.getTipoDeServicio();

                if(tipoServicio>0)
                proveedorDto.setTipoDeServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());
            }

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", proveedorDtos, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }


    @GetMapping(ApiRoutes.BUSCAR_PROVEEDOR_POR_ID)
    public ResponseEntity<ApiResponse<?>> findProveedorById(@PathVariable int id) throws NotFoundException{
        
        Proveedor proveedor = proveedorService.findById(id);

        ProveedorDto proveedorDto = proveedorMapper.toDto(proveedor);
        
        int tipoProv = proveedorDto.getTipoProveedor();
                
        proveedorDto.setTipoProveedorDescripcion(catalogoService.findById(tipoProv).getDescripcion());

        int tipoDocumento = proveedorDto.getTipoDocumento();

        proveedorDto.setTipoDocumentoDescripcion(catalogoService.findById(tipoDocumento).getDescripcion());
        
        int tipoServicio = proveedorDto.getTipoDeServicio();

        proveedorDto.setTipoDeServicioDescripcion(catalogoService.findById(tipoServicio).getDescripcion());

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", proveedorDto, Collections.emptyList()));
        
    }

    @PostMapping(ApiRoutes.CREAR_PROVEEDOR)
    public ResponseEntity<ApiResponse<?>> create(@Valid @RequestBody CreateProveedorRequest request) {
        try {
            Proveedor proveedor = proveedorMapper.createRequestToEntity(request);

            proveedorService.add(proveedor);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_PROVEEDOR)
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody UpdateProveedorRequest request)  throws NotFoundException{
        
        Proveedor proveedor = proveedorService.findById(request.getId());
        
        proveedorMapper.updateRequestToEntity(proveedor, request);

        proveedorService.update(proveedor);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_PROVEEDOR)
    public ResponseEntity<ApiResponse<?>> deleteProveedor(@PathVariable int id)  throws NotFoundException{
        
            Proveedor proveedor = proveedorService.findById(id);
                    
            proveedorService.delete(proveedor);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }
}
