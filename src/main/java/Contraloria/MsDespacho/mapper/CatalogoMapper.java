package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.Catalogo.CreateCatalogoRequest;
import Contraloria.MsDespacho.dto.Catalogo.CatalogoDto;
import Contraloria.MsDespacho.dto.Catalogo.UpdateCatalogoRequest;
import Contraloria.MsDespacho.model.Catalogo;

@Mapper(componentModel = "spring")
public interface CatalogoMapper {
    
    CatalogoDto toDto(Catalogo enumerado);


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
    Catalogo createRequestToEntity(CreateCatalogoRequest createCatalogoRequest);

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
    void updateRequestToEntity(@MappingTarget Catalogo entity,UpdateCatalogoRequest updateCatalogoRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
