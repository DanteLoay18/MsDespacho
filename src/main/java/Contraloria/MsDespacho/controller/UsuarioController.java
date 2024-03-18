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
import Contraloria.MsDespacho.dto.Usuario.CreateUsuarioRequest;
import Contraloria.MsDespacho.dto.Usuario.UpdateUsuarioRequest;
import Contraloria.MsDespacho.dto.Usuario.UsuarioDto;
import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.mapper.UsuarioMapper;
import Contraloria.MsDespacho.model.Usuario;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_USUARIO)
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioMapper usuarioMapper;
    

    @GetMapping(ApiRoutes.LISTAR_USUARIOS)
    public ResponseEntity<ApiResponse<?>> getUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            List<UsuarioDto> usuariosDto = usuarios.stream()
                    .map(usuarioMapper::toDto)
                    .collect(Collectors.toList());

         
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                    "", usuariosDto, Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }


    @GetMapping(ApiRoutes.BUSCAR_USUARIO_POR_ID)
    public ResponseEntity<ApiResponse<?>> findSolicitudById(@PathVariable int id) throws NotFoundException{
        
        Usuario usuario = usuarioService.findById(id);

        UsuarioDto usuarioResponse = usuarioMapper.toDto(usuario);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                "", usuarioResponse, Collections.emptyList()));
        
    }

    @PostMapping(ApiRoutes.CREAR_USUARIO)
    public ResponseEntity<ApiResponse<?>> createUsuario(@Valid @RequestBody CreateUsuarioRequest request) {
        try {
            Usuario usuario = usuarioMapper.createRequestToEntity(request);

            usuarioService.add(usuario);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                        MensajesParametrizados.MENSAJE_CREAR_EXITOSO, null,Collections.emptyList()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, null,Collections.emptyList()));
        }
    }

    @PutMapping(ApiRoutes.ACTUALIZAR_USUARIO)
    public ResponseEntity<ApiResponse<?>> updateUsuario(@Valid @RequestBody UpdateUsuarioRequest request)  throws NotFoundException{
        
        Usuario usuario = usuarioService.findById(request.getId());

        usuario = usuarioMapper.updateRequestToEntity(request);

        usuarioService.update(usuario);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                                                    MensajesParametrizados.MENSAJE_EDITADO_EXITOSO, null, Collections.emptyList() ));
        
    }

    @DeleteMapping(ApiRoutes.ELIMINAR_USUARIO)
    public ResponseEntity<ApiResponse<?>> deleteUsuario(@PathVariable int id)  throws NotFoundException{
        
            Usuario usuario = usuarioService.findById(id);
                    
            usuarioService.delete(usuario);

            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
                MensajesParametrizados.MENSAJE_ELIMINAR_EXITOSO, null,Collections.emptyList()));

        
    }
    





}
