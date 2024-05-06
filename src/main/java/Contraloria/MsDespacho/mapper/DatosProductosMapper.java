package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.DatosProductos.CreateDatosProductosRequest;
import Contraloria.MsDespacho.dto.DatosProductos.DatosProductosDto;
import Contraloria.MsDespacho.dto.DatosProductos.UpdateDatosProductosRequest;
import Contraloria.MsDespacho.model.DatosProductos;

@Mapper(componentModel = "spring")
public interface DatosProductosMapper {
    DatosProductosDto toDto(DatosProductos datosProductos);

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
    DatosProductos createRequestToEntity(CreateDatosProductosRequest createDatosProductosRequest);

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
    void updateRequestToEntity(@MappingTarget DatosProductos entity,UpdateDatosProductosRequest UpdateDatosProductosRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
