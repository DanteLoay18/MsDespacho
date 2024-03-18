package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.Usuario.CreateUsuarioRequest;
import Contraloria.MsDespacho.dto.Usuario.UpdateUsuarioRequest;
import Contraloria.MsDespacho.dto.Usuario.UsuarioDto;
import Contraloria.MsDespacho.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper{
   
    UsuarioDto toDto(Usuario usuario);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioCreacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    Usuario createRequestToEntity(CreateUsuarioRequest createUsuarioRequest);

    @Mappings({
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true ),
        @Mapping(target = "usuarioCreacion", ignore = true ),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioModificacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    Usuario updateRequestToEntity(UpdateUsuarioRequest updateUsuarioRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
