package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.Enumerado.CreateEnumeradoRequest;
import Contraloria.MsDespacho.dto.Enumerado.EnumeradoDto;
import Contraloria.MsDespacho.dto.Enumerado.UpdateEnumeradoRequest;
import Contraloria.MsDespacho.model.Enumerado;

@Mapper(componentModel = "spring")
public interface EnumeradoMapper {
    
    
    EnumeradoDto toDto(Enumerado enumerado);


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
    Enumerado createRequestToEntity(CreateEnumeradoRequest createEnumeradoRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioModificacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    Enumerado updateRequestToEntity(UpdateEnumeradoRequest updateEnumeradoRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
